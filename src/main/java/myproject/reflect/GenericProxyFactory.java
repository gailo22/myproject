package myproject.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class GenericProxyFactory {

	public static <T> T getProxy(final Class<T> interfaces, final T object) {
		return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(), new Class[] { interfaces },
				new InvocationHandler() {
					@Override
					public Object invoke(final Object proxy, final Method method, final Object[] args) throws Throwable {
						return method.invoke(object, args);
					}
				});
	}
}
