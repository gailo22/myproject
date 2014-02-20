package myproject.exptree;

public class LeafNode extends ComponentNode {

	LeafNode(int item) {
		this.item = item;
	}

	@Override
	void accept(ETVisitor visitor) {
		// TODO Auto-generated method stub

	}

}
