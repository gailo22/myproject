package myproject.mixin;

import java.lang.reflect.Method;

import org.junit.Test;

public class MixinTest {

    @Test
    public void test() throws Exception {
//        Mixin mixin = Mixin.create(new Object[]{ new Class1(), new Class2() });
//        assertEquals(1, invokeMethod(mixin, "method1"));
//        assertEquals(2, invokeMethod(mixin, "method2"));
    }
    
    public static Object invokeMethod(Object target, String methodName) throws Exception {
        Method method = target.getClass().getMethod(methodName);
        return method.invoke(target);
    }

    private interface Interface1 {
        public int method1();
    }

    private interface Interface2 {
        public int method2();
    }

    private static class Class1 implements Interface1 {

        @Override
        public int method1() {
            return 1;
        }
    }

    private static class Class2 implements Interface2 {

        @Override
        public int method2() {
            return 2;
        }
    }
}
