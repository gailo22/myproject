package myproject.simpleserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NonblockingMultiThreadedSelectorServer {

	private static Map<SocketChannel, Queue<ByteBuffer>> pendingData = new ConcurrentHashMap<SocketChannel, Queue<ByteBuffer>>();

	private static Queue<SocketChannel> toWrite = new ConcurrentLinkedQueue<SocketChannel>();

	private static ExecutorService pool = Executors.newFixedThreadPool(100);

	public static void main(String... args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress("localhost", 8080));
		ssc.configureBlocking(false);

		Selector selector = Selector.open();
		ssc.register(selector, SelectionKey.OP_ACCEPT);

		while (true) {
			selector.select();

			SocketChannel changeToWrite;
			while ((changeToWrite = toWrite.poll()) != null) {
				changeToWrite.register(selector, SelectionKey.OP_WRITE);
			}

			for (Iterator<SelectionKey> itKey = selector.selectedKeys().iterator(); itKey.hasNext();) {
				SelectionKey key = itKey.next();
				itKey.remove();

				if (key.isValid()) {
					if (key.isAcceptable()) {
						accept(key);
					} else if (key.isReadable()) {
						read(key);
					} else if (key.isWritable()) {
						write(key);
					}
				}
			}
		}

	}

	private static void write(SelectionKey key) throws IOException {
		SocketChannel sc = (SocketChannel) key.channel();

		Queue<ByteBuffer> queue = pendingData.get(sc);

		ByteBuffer buf;
		while ((buf = queue.peek()) != null) {
			sc.write(buf);

			if (!buf.hasRemaining()) {
				queue.poll();
			} else {
				return;
			}
		}
		sc.register(key.selector(), SelectionKey.OP_READ);
	}

	private static void read(final SelectionKey key) {
		final SocketChannel sc = (SocketChannel) key.channel();

		try {
			final ByteBuffer buf = ByteBuffer.allocateDirect(1024);

			int read = sc.read(buf);
			if (read == -1) {
				pendingData.remove(sc);
				return;
			}

			buf.flip();

			pool.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					aux(key, sc, buf);
					return null;
				}
			});
		} catch (IOException ex) {
			System.out.println("Connection problem: " + ex);
		}
	}

	private static void aux(SelectionKey key, SocketChannel sc, ByteBuffer buf) throws ClosedChannelException {
		for (int i = 0; i < buf.limit(); i++) {
			buf.put(1, (byte) Util.transmogrify(buf.get(i)));
		}
		pendingData.get(sc).add(buf);
		Selector selector = key.selector();
		toWrite.add(sc);
		selector.wakeup();

	}

	private static void accept(SelectionKey key) throws IOException {
		ServerSocketChannel ssc = (ServerSocketChannel) key.channel();

		// non blocking, never null
		SocketChannel sc = ssc.accept();
		sc.configureBlocking(false);
		sc.register(key.selector(), SelectionKey.OP_READ);
		pendingData.put(sc, new ConcurrentLinkedQueue<ByteBuffer>());
	}

}
