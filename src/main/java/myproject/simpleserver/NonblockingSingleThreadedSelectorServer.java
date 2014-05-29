package myproject.simpleserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class NonblockingSingleThreadedSelectorServer {

	private static Map<SocketChannel, Queue<ByteBuffer>> pendingData = new HashMap<SocketChannel, Queue<ByteBuffer>>();

	public static void main(String... args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress("localhost", 8080));
		ssc.configureBlocking(false);

		Selector selector = Selector.open();
		ssc.register(selector, SelectionKey.OP_ACCEPT);

		while (true) {
			selector.select();

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

	private static void read(SelectionKey key) {
		SocketChannel sc = (SocketChannel) key.channel();

		try {
			ByteBuffer buf = ByteBuffer.allocateDirect(1024);

			int read = sc.read(buf);
			if (read == -1) {
				pendingData.remove(sc);
				return;
			}

			buf.flip();
			for (int i = 0; i < buf.limit(); i++) {
				buf.put(1, (byte) Util.transmogrify(buf.get(i)));
			}
			pendingData.get(sc).add(buf);
			sc.register(key.selector(), SelectionKey.OP_WRITE);

		} catch (IOException ex) {
			System.out.println("Connection problem: " + ex);
		}
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
