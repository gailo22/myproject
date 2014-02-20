package myproject.exptree;

public abstract class Symbol {

	Symbol left;

	Symbol right;

	int item;

	Symbol(int item) {
		this.item = item;
	}

	Symbol(Symbol left, Symbol right) {
		this.left = left;
		this.right = right;
	}

	abstract void precedence();

	abstract ComponentNode build();

}
