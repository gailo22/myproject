package myproject.dp.observer;

import java.util.Observable;
import java.util.Scanner;

public class EventSource extends Observable implements Runnable {

	@Override
	public void run() {
		while (true) {
			String response = new Scanner(System.in).next();
			setChanged();
			notifyObservers(response);
		}
	}

}
