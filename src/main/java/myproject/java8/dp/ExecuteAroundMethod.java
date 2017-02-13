package myproject.java8.dp;

import java.util.function.Predicate;
import java.util.function.Supplier;

public class ExecuteAroundMethod {

	public static void main(String[] args) {
		
		method1("hi");
		System.out.println("------------");
		aroundSupplier("admin", () -> method1("hello"));
		System.out.println("------------");
		aroundSupplier("user", () -> method1("hahaha"));
		
	}
	
	
	static <R> R aroundSupplier(String userName, Supplier<R> supplier) {
		System.out.println("start...");
		if (validate(x -> x.equals(userName))) {
			R result = supplier.get();
			System.out.println("end...");
			return result;
		} else {
			System.out.println("end with exception...");
			throw new RuntimeException("validation failed");
		}
	}
	
	static boolean validate(Predicate<String> validator) {
		return validator.test("admin");
	}
	
	static String method1(String param) {
		System.out.println("method1: " + param);
		return param;
	}
}
