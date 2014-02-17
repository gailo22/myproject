package myproject.mupl;

public class Add extends Exp {
	
	Exp l;
	
	Exp r;
	
	Add(Exp l, Exp r) {
		this.l = l;
		this.r = r;
	}

	@Override
	void preProcess() {

	}

	@Override
	int eval() {
		return l.eval() + r.eval();
	}

}
