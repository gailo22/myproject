package myproject.collections.interpreter;

public class Pair<A, B> {

	private final A left;

	private final B right;

	public Pair(A l, B r) {
		this.left = l;
		this.right = r;
	}

	public A left() {
		return left;
	}

	public B right() {
		return right;
	}
}
