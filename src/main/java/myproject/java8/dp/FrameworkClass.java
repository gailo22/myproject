package myproject.java8.dp;

import java.util.List;
import java.util.function.Consumer;

public interface FrameworkClass {
	
	default void templateMethod(List<Consumer<Thread>> steps) {
		System.out.println("start...");
		steps.forEach(step -> {
			Thread thread = new Thread();
			step.accept(thread);
		});
		System.out.println("end...");
	}

}
