package myproject.mupl;

public class Fst extends Exp {

	Exp e;

	Fst(Exp e) {
		this.e = e;
	}

	@Override
	void preProcess() {
	}

	@Override
	ExpValue eval() {
		if (e instanceof Pair) {
			Pair p = (Pair) e;
			return p.getF().eval();
		} else {
			throw new IllegalArgumentException("fst applied to non-apair!");
		}
	}

}
