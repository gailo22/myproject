package myproject.mupl;

public class Add extends Exp {
	
	Exp e1;
	
	Exp e2;
	
	Add(Exp e1, Exp e2) {
		this.e1 = e1;
		this.e2 = e2;
	}

	@Override
	void preProcess() {

	}

	@Override
	ExpValue eval() {
		return e1.eval().add(e2);
	}

}
