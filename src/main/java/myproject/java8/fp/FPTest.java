package myproject.java8.fp;

import java.util.Arrays;
import java.util.function.BiFunction;

import myproject.lombok.Customer;
import myproject.subtyping.T1;

public class FPTest {

	public static void main(String[] args) {
		
		Identity<String> idString = new Identity<>("hello");
		Identity<Integer> idInt = idString.map(String::length);

		Customer cust1 = Customer.builder().id(1).firstName("John").build();
		Customer cust2 = Customer.builder().id(2).firstName("James").build();
		
		ListF<Customer> customers = new ListF<>(Arrays.asList(cust1, cust2));
		
		ListF<String> firstNames = customers.map(Customer::getFirstName);

		firstNames.map(s -> { System.out.println(s); return s; });
		
		OptionF<String> str = OptionF.of("42");
		OptionF<OptionF<Integer>> num = str.map(FPTest::tryParse);
		
	}
	
	private static OptionF<Integer> tryParse(String s) {
	    try {
	        final int i = Integer.parseInt(s);
	        return OptionF.of(i);
	    } catch (NumberFormatException e) {
	        return OptionF.empty();
	    }
	}
	
//	private static Monad<R> liftM2(Monad<T1> t1, Monad<T2> t2, BiFunction<T1, T2, R> fun) {
//	    return t1.flatMap((T1 tv1) ->
//	            t2.map((T2 tv2) -> fun.apply(tv1, tv2))
//	    );
//	}

}
