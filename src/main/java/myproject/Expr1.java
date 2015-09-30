package myproject;


public class Expr1 {

	public static void main(String[] args) {

		Expr e = new Add(new Sub(new Add(new Int(1), new Int(2)), new Int(3)), new Int(10));

		Integer result = eval(e);
		System.out.println("result: " + result);

	}

	private static Integer eval(Expr e) {
		if (e instanceof Int) {
			return ((Int) e).value;
		} else if (e instanceof Add) {
			return ((Add) e).eval();
		} else if (e instanceof Sub) {
			return ((Sub) e).eval();
		}

		throw new RuntimeException("Doesn't match!");
	}

	static interface Expr {
		Integer eval();
	}

	static class Sub implements Expr {
		Expr l, r;

		Sub(Expr l, Expr r) {
			this.l = l;
			this.r = r;
		}

		@Override
		public Integer eval() {
			return l.eval() - r.eval();
		}
	}

	static class Add implements Expr {
		Expr l, r;

		Add(Expr l, Expr r) {
			this.l = l;
			this.r = r;
		}

		@Override
		public Integer eval() {
			return l.eval() + r.eval();
		}
	}

	static class Int implements Expr {
		Integer value;

		Int(Integer i) {
			this.value = i;
		}

		@Override
		public Integer eval() {
			return value;
		}
	}

}
