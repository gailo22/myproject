package myproject;

public class ThreadSafeSingleton {

	private ThreadSafeSingleton() {
		// private constructor
	}
	
	// 1. double check singleton
	private static volatile ThreadSafeSingleton singleton = null;

	public static ThreadSafeSingleton getInstance() {
		if (singleton == null) {
			synchronized (ThreadSafeSingleton.class) {
				if (singleton == null) {
					singleton = new ThreadSafeSingleton();
				}
			}
		}
		return singleton;
	}
	
	// 2. eager singleton
	private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();

	public static ThreadSafeSingleton getInstance2() {
		return INSTANCE;
	}

	// 3. Initialization-on-demand holder singleton
	private static class SingletonHolder {
		private static final ThreadSafeSingleton INSTANCE = new ThreadSafeSingleton();
	}

	public static ThreadSafeSingleton getInstance3() {
		return SingletonHolder.INSTANCE;
	}
	
	// 4. enum singleton
	public enum Singleton {
		INSTANCE;
		public void execute(String arg) {
			// Perform operation here
		}
	}
}
