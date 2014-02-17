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
	int eval() {
		if (e instanceof Pair) {
			Pair p = (Pair) e;
			return p.getFirst().eval();
		} else {
			throw new IllegalArgumentException("fst applied to non-apair!");
		}
	}

}
