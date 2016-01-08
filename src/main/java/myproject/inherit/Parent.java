package myproject.inherit;

public class Parent {

	public void a() {
		System.out.println("parent.a()");
	}

	public void a(final Object o) {
		System.out.println("parent.a(object)");
	}

	public void a(final String s) {
		System.out.println("parent.a(string)");
	}

	public Parent aa() {
		System.out.println("parent.aa()");
		return this;
	}

	public static void main(final String[] args) {
		final Parent parent = new Parent();
		parent.a();
		final String s = new String("hello");
		parent.a(s);
		final Object o = new String("hello");
		parent.a(o);

		final Parent child = new Child();
		child.aa();
		
		child.hello();
	}
	
	public static void hello() {
		System.out.println("Hello from Parent");
	}

//	parent.a()
//	parent.a(string)
//	parent.a(object)
//	child.aa()

}
