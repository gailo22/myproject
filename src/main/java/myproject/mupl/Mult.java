package myproject.mupl;

public class Mult extends Exp {

	Exp e1;

	Exp e2;

	Mult(Exp e1, Exp e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	@Override
	void preProcess() {

	}

	@Override
	ExpValue eval() {
		return e1.eval().mult(e2);
	}


}
