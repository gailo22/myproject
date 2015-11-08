package myproject.mixin;

import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.Locale;

import net.sf.cglib.proxy.Mixin;
import net.sf.cglib.proxy.Mixin.Generator;

public class CglibTest {

    public static void main(String[] args) throws Exception {
        Generator gen = new Generator();
        gen.setStyle(Mixin.STYLE_EVERYTHING);
        gen.setDelegates(new Object[]{ Charset.defaultCharset(), Locale.getDefault()});
        Mixin mixin = gen.create();
        System.out.println(invokeMethod(mixin, "displayName"));
        System.out.println(invokeMethod(mixin, "getCountry"));
    }  


    public static Object invokeMethod(Object target, String methodName) throws Exception {
        Method method = target.getClass().getMethod(methodName);
        return method.invoke(target);
    }

}