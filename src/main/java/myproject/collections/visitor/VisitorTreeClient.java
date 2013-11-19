package myproject.collections.visitor;

public class VisitorTreeClient {

	public static <T> String toString(VisitorTree<T> t) {
		return t.visit(new VisitorTree.Visitor<T, String>() {

			@Override
			public String leaf(T elt) {
				return elt.toString();
			}

			@Override
			public String branch(String left, String right) {
				return "(" + left + "^" + right + ")";
			}
		});
	}

	public static <N extends Number> double sum(VisitorTree<N> t) {
		return t.visit(new VisitorTree.Visitor<N, Double>() {

			@Override
			public Double leaf(N elt) {
				return elt.doubleValue();
			}

			@Override
			public Double branch(Double left, Double right) {
				return left + right;
			}
		});
	}

	public static void main(String[] args) {
		VisitorTree<Integer> t = VisitorTree.branch(VisitorTree.branch(VisitorTree.leaf(1), VisitorTree.leaf(2)),
				VisitorTree.leaf(3));

		System.out.println(toString(t));
	}

}
