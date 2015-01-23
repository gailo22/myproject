package myproject.subtyping;

public class B extends A<Object, Object> {
    
    
    public static void main(String[] args) {
        A<?, ?> a = new B();
        a.a(null);
    }

}
