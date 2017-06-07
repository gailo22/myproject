package myproject.java8.dp;

import java.util.List;
import java.util.function.Consumer;

import com.google.common.collect.Lists;

public class ApplicationClass1 implements FrameworkClass {
	
	public void templateMethod(String param) {
		List<Consumer<Thread>> steps = Lists.newArrayList();
		steps.add(t -> System.out.println(t.getName() + " step1: " + param));
		steps.add(t -> System.out.println(t.getName() + " step2: " + param));
		steps.add(t -> System.out.println(t.getName() + " step3: " + param));
		
		templateMethod(steps);
	}

}
