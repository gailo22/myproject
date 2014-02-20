package myproject.exptree;

public class Number extends Symbol {

	Number(int item) {
		super(item);
	}

	@Override
	void precedence() {
		// TODO Auto-generated method stub

	}

	@Override
	ComponentNode build() {
		return new LeafNode(item);
	}

}
