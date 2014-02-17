package myproject.mupl;

public class Mult extends Exp {

	Exp l;

	Exp r;

	Mult(Exp l, Exp r) {
		this.l = l;
		this.r = r;
	}

	@Override
	void preProcess() {

	}

	@Override
	int eval() {
		return l.eval() * r.eval();
	}


}
