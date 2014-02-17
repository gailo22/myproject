package myproject.mupl;

public class Negate extends Exp {

	Exp e;

	Negate(Exp e) {
		this.e = e;
	}

	@Override
	void preProcess() {

	}

	@Override
	ExpValue eval() {
		return e.eval().negate();
	}

}
