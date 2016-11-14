package myproject.java8.fp;

import java.util.Arrays;

import myproject.lombok.Customer;

public class FPTest {

	public static void main(String[] args) {
		
		Identity<String> idString = new Identity<>("hello");
		Functor<Integer> idInt = idString.map(String::length);

		Customer cust1 = Customer.builder().id(1).firstName("John").build();
		Customer cust2 = Customer.builder().id(2).firstName("James").build();
		
		ListF<Customer> customers = new ListF<>(Arrays.asList(cust1, cust2));
		
		Functor<String> firstNames = customers.map(Customer::getFirstName);

		firstNames.map(s -> { System.out.println(s); return s; });
		
	}

}
