package myproject.processbuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProcessBuilderExample {
	
	public static void main(String[] args) {
	    List<String> commands = new ArrayList<String>();
	    commands.add("/bin/sh");
	    commands.add("-c");
	    commands.add("ls -l /var/tmp | grep tmp");

	    SystemCommandExecutor commandExecutor = new SystemCommandExecutor(commands);
		try {
			int result = commandExecutor.executeCommand();
			StringBuilder stdout = commandExecutor.getStandardOutputFromCommand();
			StringBuilder stderr = commandExecutor.getStandardErrorFromCommand();
			
			System.out.println("The numeric result of the command was: " + result);
			System.out.println("STDOUT:");
			System.out.println(stdout);
			System.out.println("STDERR:");
			System.out.println(stderr);
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}

	}

}
