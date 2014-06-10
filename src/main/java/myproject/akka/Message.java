package myproject.akka;

import java.io.Serializable;

public class Message implements Serializable {

	private static final long serialVersionUID = 5622348923538309662L;
	
	private String message;
	
	public Message(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
}
