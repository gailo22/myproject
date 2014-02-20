package myproject.exptree;

public class Multiply extends Operator {

	Multiply(Symbol left, Symbol right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	ComponentNode build() {
		return new CompositeMultiplyNode();
	}

}
