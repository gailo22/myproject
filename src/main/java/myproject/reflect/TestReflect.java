package myproject.reflect;

import java.util.HashSet;
import java.util.Set;

public class TestReflect {


	public static void main(final String[] args) {

		final FooImpl f = new FooImpl();
		final Foo proxyF = GenericProxyFactory.getProxy(Foo.class, f);
		proxyF.doSomething();

		final Set setProxy = SetProxyFactory.getSetProxy(new HashSet());
		setProxy.add("abc");
		setProxy.isEmpty();

		new TestReflect().mehtodA();

	}

	public void mehtodA() {
		methodName();
	}

	public static String methodName() {
		return Thread.currentThread().getStackTrace()[1].getMethodName();
	}

}
