package myproject.dp.observer;

import java.util.Observable;
import java.util.Observer;

public class MyApp {

	public static void main(String[] args) {
		System.out.println("Enter Text: ");
		EventSource eventSource = new EventSource();
		
		eventSource.addObserver(new Observer() {
			@Override
			public void update(Observable obj, Object arg) {
				System.out.println("Received response: " + arg);
			}
		});
		
		new Thread(eventSource).start();
	}
}
