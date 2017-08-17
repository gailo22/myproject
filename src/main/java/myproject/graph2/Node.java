package myproject.graph2;

public class Node {

	protected String element;

	public Node(String element) {
		this.element = element;
	}
	
	public String getElement() {
		return element;
	}

	@Override
	public String toString() {
		return element;
	}

}
