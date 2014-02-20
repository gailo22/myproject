package myproject.exptree;

public class Negate extends UnaryOperator {

	Negate(int item) {
		super(item);
	}

	@Override
	ComponentNode build() {
		return new CompositeNegateNode(item);
	}

}
