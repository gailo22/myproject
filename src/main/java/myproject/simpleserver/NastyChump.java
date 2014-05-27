package myproject.simpleserver;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class NastyChump {

	public static void main(String[] args) {

		for (int i = 0; i < 3000; i++) {
			try {
				new Socket("localhost", 8080);
				System.out.println(i);
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
