package myproject.exptree;

public class Divide extends Operator {

	Divide(Symbol left, Symbol right) {
		super(left, right);
	}

	@Override
	ComponentNode build() {
		return new CompositeDivideNode(left.build(), right.build());
	}

}
