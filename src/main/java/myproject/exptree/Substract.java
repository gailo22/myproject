package myproject.exptree;

public class Substract extends Operator {

	Substract(Symbol left, Symbol right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	ComponentNode build() {
		return new CompositeSubstractNode();
	}

}
