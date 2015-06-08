package myproject.loop;

class Loop {

	private static volatile boolean running = true;

	public static void main(String[] args) {

		final Thread mainThread = Thread.currentThread();

		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				mainThread.interrupt();
				System.out.println("shutdown");
			}
		});

		while (running) {

			System.out.println("Running...");

			try {
				Thread.sleep(1000);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
