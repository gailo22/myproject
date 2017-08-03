package myproject.clientserver;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileServer {
	
	private static void run(ServerSocket socket, File rootDir) throws IOException {
		while (true) {
			Socket s = socket.accept();
			
			new Thread(() -> {
				
				InputStream in = null;
				OutputStream out = null;
				
				try {
					in = s.getInputStream();
					out = s.getOutputStream();
					
					InputStreamReader reader = new InputStreamReader(in);
					BufferedReader buffered = new BufferedReader(reader);
					
//					String line = buffered.readLine();
//					assert line != null;
//					assert line.startsWith("GET");
//					
//					String path = line.split(" ")[1];
//					File fullPath = new File(rootDir, path);
					
					PrintWriter printer = new PrintWriter(out);
					printer.write("hello from server");
					
//					if (fullPath.isFile()) {
//						printer.write("HTTP/1.0 200 OK\r\n");
//						printer.write("\r\n");
//						printer.write("\r\n");
//						printer.write(new String(Files.readAllBytes(fullPath.toPath())) + "\r\n");
//					} else {
//						printer.write("HTTP/1.0 404 Not Found\r\n");
//						printer.write("\r\n");
//						printer.write("\r\n");
//					}

					printer.close();
					
				} catch (IOException io) {
					io.printStackTrace();
					throw new RuntimeException(io);
				} finally {
					try {
						in.close();
					} catch (Exception e) {}
					try {
						out.close();
					} catch (Exception e) {}
				}
			}).start();
			
		}
	}
	
	public static void main(String[] args) {
		
		try {
			ServerSocket socket = new ServerSocket(8888);
			socket.setReuseAddress(true);
			
			System.out.println("Server started at port: " + socket.getLocalPort());
			
			FileServer.run(socket, Paths.get("D:\\tmp").toFile());
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
 
}
