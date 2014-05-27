package myproject.simpleserver;

import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

	public static void main(String[] args) throws Exception {
		ServerSocket ss = new ServerSocket(8080);
		System.out.println("Server started at port: " + ss.getLocalPort());
		while (true) {
			Socket s = ss.accept();
			Util.process(s);
		}

	}

}
