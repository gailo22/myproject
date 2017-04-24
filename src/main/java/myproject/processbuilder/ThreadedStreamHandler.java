package myproject.processbuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

class ThreadedStreamHandler extends Thread {
	InputStream inputStream;
	String adminPassword;
	OutputStream outputStream;
	PrintWriter printWriter;
	StringBuilder outputBuffer = new StringBuilder();
	private boolean sudoIsRequested = false;

	ThreadedStreamHandler(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	ThreadedStreamHandler(InputStream inputStream, OutputStream outputStream, String adminPassword) {
		this.inputStream = inputStream;
		this.outputStream = outputStream;
		this.printWriter = new PrintWriter(outputStream);
		this.adminPassword = adminPassword;
		this.sudoIsRequested = true;
	}

	public void run() {
		if (sudoIsRequested) {
			// doSleep(500);
			printWriter.println(adminPassword);
			printWriter.flush();
		}

		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				outputBuffer.append(line + "\n");
			}
		} catch (Throwable t) {
			t.printStackTrace();
		} 
	}

	private void doSleep(long millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {}
	}

	public StringBuilder getOutputBuffer() {
		return outputBuffer;
	}

}
