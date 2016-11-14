package myproject.cyclopse;

import com.aol.cyclops.control.SimpleReact;

public class SimleReact {

	public static void main(String[] args) {
		new SimpleReact().of(1,2,3,4,5)
				         .then(num -> num+100)
				         .peek(System.out::println);
		
		new SimpleReact().of(1,2,3,4,5)
				         .then(num -> num+100)
				         .then(num -> Thread.currentThread().getId())
				         .peek(System.out::println);
		
	}

}
