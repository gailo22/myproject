package myproject.simpleserver;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutorServiceServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8080);
		System.out.println("Server started at port: " + ss.getLocalPort());

		ExecutorService pool = Executors.newFixedThreadPool(1000);
		while (true) {
			final Socket s = ss.accept();
			pool.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					Util.process(s);
					return "ok";
				}

			});
		}

	}

}
