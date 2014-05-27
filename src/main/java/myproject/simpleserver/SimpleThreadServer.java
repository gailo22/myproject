package myproject.simpleserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleThreadServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket ss = new ServerSocket(8080);
		System.out.println("Server started at port: " + ss.getLocalPort());
		while (true) {
			final Socket s = ss.accept();
			new Thread(new Runnable() {

				@Override
				public void run() {
					try {
						Util.process(s);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}).start();

		}

	}

}
