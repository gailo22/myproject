package myproject.mupl;

public class Exp {
	
	public static Var eval(Exp exp) {
		return null;
	}
	
	
	public static void main(String[] args) {
		
		Var i = Exp.eval(new Add(new Int(new Var(1)), new Int(new Var(2))));
		
		System.out.println(i);
	}

}
