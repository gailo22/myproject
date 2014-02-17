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
	ExpValue eval() {
		if (e instanceof Pair) {
			Pair p = (Pair) e;
			return p.getS().eval();
		} else {
			throw new IllegalArgumentException("snd applied to non-apair!");
		}
	}
}
