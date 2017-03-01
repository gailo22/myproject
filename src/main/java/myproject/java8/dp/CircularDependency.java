package myproject.java8.dp;

import java.util.function.Function;

public class CircularDependency {

	static class A {
		B b;
		
//		A(B b) {
//			this.b = b;
//		}
		A(Function<A, B> fun) {
			this.b = fun.apply(this);
		}
	}
	static class B {
		A a;
		
		B(A a) {
			this.a = a;
		}
	}
	
	public static void main(String[] args) {
		A a = new A(B::new);
	}
}
