package myproject.mupl;

public class Snd extends Exp {

	Exp e;

	Snd(Exp e) {
		this.e = e;
	}

	@Override
	void preProcess() {
	}

	@Override
	int eval() {
		if (e instanceof Pair) {
			Pair p = (Pair) e;
			return p.getSecond().eval();
		} else {
			throw new IllegalArgumentException("fst applied to non-apair!");
		}
	}
}
