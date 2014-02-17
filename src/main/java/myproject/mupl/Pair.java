package myproject.mupl;

public class Pair extends Exp {

	Exp first;

	Exp second;

	Pair(Exp first, Exp second) {
		this.first = first;
		this.second = second;
	}

	public Exp getFirst() {
		return first;
	}

	public Exp getSecond() {
		return second;
	}

	@Override
	void preProcess() {

	}

	@Override
	int eval() {
		return 0;
	}

}
