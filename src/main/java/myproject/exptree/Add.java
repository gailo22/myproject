package myproject.exptree;

public class Add extends Operator {

	Add(Symbol left, Symbol right) {
		super(left, right);
	}

	@Override
	ComponentNode build() {
		return new CompositeAddNode(left.build(), right.build());
	}

}
