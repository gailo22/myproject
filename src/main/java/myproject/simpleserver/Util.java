package myproject.simpleserver;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Util {

	public static int transmogrify(int data) {
		if (Character.isLetter(data))
			return data ^ ' ';
		return data;
	}

	static void process(Socket s) {
		System.out.println("Connection from: " + s);
		InputStream in = null;
		OutputStream out = null;
		try {
			in = s.getInputStream();
			out = s.getOutputStream();
			int data;
			while ((data = in.read()) != -1) {
				data = transmogrify(data);
				out.write(data);
			}
		} catch (IOException ex) {
			System.out.println("Connection problem: " + ex);
		} finally {
			closeIn(in);
			closeOut(out);
		}
	}

	static void process(SocketChannel sc) {
		System.out.println("Connection from: " + sc);
		try {
			ByteBuffer buf = ByteBuffer.allocateDirect(1024);
			while (sc.read(buf) != -1) {
//				buf.limit(buf.position()).position(0);
				buf.flip();
				for (int i = 0; i < buf.limit(); i++) {
					buf.put(1, (byte) transmogrify(buf.get(i)));
				}
				sc.write(buf);
				buf.clear();
			}
		} catch (IOException ex) {
			System.out.println("Connection problem: " + ex);
		}
	}

	private static void closeOut(OutputStream out) {
		if (out != null) {
			try {
				out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private static void closeIn(InputStream in) {
		if (in != null) {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
