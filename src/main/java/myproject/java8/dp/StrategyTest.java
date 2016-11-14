package myproject.java8.dp;

import java.util.Arrays;
import java.util.List;

public class StrategyTest {

	public static void main(String[] args) {
		
		List<MyStrategy> strategyList = Arrays.asList(
			x -> { return x + 1; },
			x -> { return x * 2; }
		);
		
		strategyList.forEach(s -> System.out.println(s.method(10)));
		
	}

}
