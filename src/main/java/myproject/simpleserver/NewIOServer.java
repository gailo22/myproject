package myproject.simpleserver;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NewIOServer {

	public static void main(String[] args) throws Exception {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress("localhost", 8080));

		ExecutorService pool = Executors.newFixedThreadPool(1000);
		while (true) {
			final SocketChannel sc = ssc.accept();
			pool.submit(new Runnable() {

				@Override
				public void run() {
					Util.process(sc);
				}

			});
		}

	}

}
