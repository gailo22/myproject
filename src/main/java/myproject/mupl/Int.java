package myproject.mupl;

public class Int extends Exp implements ExpValue {
	
	int i;

	Int(int i) {
		this.i = i;
	}

	@Override
	public int val() {
		return i;
	}

	@Override
	public ExpValue add(Exp e) {
		return new Int(i + e.eval().val());
	}

	@Override
	public ExpValue mult(Exp e) {
		return new Int(i * e.eval().val());
	}

	@Override
	public ExpValue negate() {
		return new Int(i * -1);
	}

	@Override
	void preProcess() {
	}

	@Override
	ExpValue eval() {
		return new Int(i);
	}

	@Override
	public String toString() {
		return String.valueOf(i);
	}

}
