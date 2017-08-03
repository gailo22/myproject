package myproject.clientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;

public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 8888);
		
		OutputStream out = socket.getOutputStream();
		out.write("GET synonyms.txt".getBytes());
		
		InputStream in = socket.getInputStream();
		InputStreamReader reader = new InputStreamReader(in);
		BufferedReader buffered = new BufferedReader(reader);
		
		String line = buffered.readLine();
		
		System.out.println(line);
		
		out.close();
		in.close();
		
//		URL obj = new URL("http://localhost:8888/synonyms.txt");
//
//        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//        con.setRequestMethod("GET");
//        con.setConnectTimeout(5000); // 5 seconds
//        con.setReadTimeout(5000); // 5 seconds
//        
//        final int responseCode = con.getResponseCode();
//
//        final String responseStr;
//        if (responseCode != 404) {
//            BufferedReader in = new BufferedReader(
//                    new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            in.close();
//
//            responseStr = response.toString();
//        } else {
//            responseStr = "";
//        }
//
//        System.err.println("reponse code is " + responseCode +
//                ", with content length " + responseStr.length());
	}
}
