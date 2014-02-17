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
	int eval() {
		return e.eval() * -1;
	}

}
