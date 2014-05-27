package myproject.simpleserver;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Util {

	public static int transmogrify(int data) {
		if (Character.isLetter(data))
			return data ^ ' ';
		return data;
	}

	static void process(Socket s) throws Exception {
		InputStream in = s.getInputStream();
		OutputStream out = s.getOutputStream();
		int data;
		while ((data = in.read()) != -1) {
			data = transmogrify(data);
			out.write(data);
		}
	}

}
