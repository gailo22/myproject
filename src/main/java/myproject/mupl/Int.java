package myproject.mupl;

public class Int extends Exp {
	
	int i;

	Int(int i) {
		this.i = i;
	}

	@Override
	void preProcess() {

	}

	@Override
	int eval() {
		return i;
	}

}
