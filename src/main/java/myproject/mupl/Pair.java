package myproject.mupl;

public class Pair extends Exp {

	Exp f;

	Exp s;

	Pair(Exp f, Exp s) {
		this.f = f;
		this.s = s;
	}

	public Exp getF() {
		return f;
	}

	public Exp getS() {
		return s;
	}

	@Override
	void preProcess() {
	}

	@Override
	ExpValue eval() {
		return null;
	}

}
