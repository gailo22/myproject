package myproject.inherit;

public class Child extends Parent {

	// Override and change return type
	@Override()
	public Child aa() {
		System.out.println("child.aa()");
		return this;
	}

	//@Override
	public static void hello() {
		System.out.println("Hello from Child");
	}
}
