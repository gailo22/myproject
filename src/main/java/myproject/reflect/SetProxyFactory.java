package myproject.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

public class SetProxyFactory {

	public static Set getSetProxy(final Set s) {
		return (Set) Proxy.newProxyInstance(s.getClass().getClassLoader(), new Class[] { Set.class },
				new InvocationHandler() {
			@Override
			public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
						System.out.println("before call set method: " + method.getName());
				return method.invoke(s, args);
			}
		});
	}
}
