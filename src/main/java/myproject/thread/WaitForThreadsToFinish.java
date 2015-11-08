package myproject.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class WaitForThreadsToFinish implements Runnable {

  public static void main(String[] args) throws Exception {

    int poolSize = 10;

    ExecutorService service = Executors.newFixedThreadPool(poolSize);
    List<Future<Runnable>> futures = new ArrayList<Future<Runnable>>();

    for (int n = 0; n < 100; n++) {
      Future f = service.submit(new WaitForThreadsToFinish());
      futures.add(f);
    }

    // wait for all threads to finish
    for (Future<Runnable> f : futures) {
      f.get();
    }

    service.shutdown();

  }

  public void run() {
    // do somthing
    System.out.println("1");
  }

}
