package myproject.mupl;

public class MUPLTest {

	public static void main(String[] args) {

		Add add = new Add(new Int(4), new Int(3));
		Mult mult = new Mult(add, new Int(2));
		Negate negate = new Negate(mult);

		Pair p = new Pair(new Int(5), new Int(6));
		Fst f = new Fst(p);
		Snd s = new Snd(p);

		System.out.println(add.eval());
		System.out.println(mult.eval());
		System.out.println(negate.eval());

		System.out.println(f.eval());
		System.out.println(s.eval());

	}

}
