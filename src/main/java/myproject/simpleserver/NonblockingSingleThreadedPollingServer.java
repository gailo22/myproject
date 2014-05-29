package myproject.simpleserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class NonblockingSingleThreadedPollingServer {

	private static Collection<SocketChannel> sockets = Collections.newSetFromMap(new HashMap<SocketChannel, Boolean>());

	public static void main(String... args) throws IOException {
		ServerSocketChannel ssc = ServerSocketChannel.open();
		ssc.socket().bind(new InetSocketAddress("localhost", 8080));
		ssc.configureBlocking(false);

		while (true) {
			final SocketChannel sc = ssc.accept();
			if (sc != null) {
				System.out.println("Connection from: " + sc);
				sc.configureBlocking(false);

				sockets.add(sc);
			}

			for (Iterator<SocketChannel> it = sockets.iterator(); it.hasNext();) {
				SocketChannel socket = it.next();
				try {
					ByteBuffer buf = ByteBuffer.allocateDirect(1024);

					int read = socket.read(buf);
					if (read == -1) {
						it.remove();
					} else if (read != 0) {
						buf.flip();
						for (int i = 0; i < buf.limit(); i++) {
							buf.put(1, (byte) Util.transmogrify(buf.get(i)));
						}
						socket.write(buf);
					}
				} catch (IOException ex) {
					System.out.println("Connection problem: " + ex);
				}
			}

		}

	}

}
