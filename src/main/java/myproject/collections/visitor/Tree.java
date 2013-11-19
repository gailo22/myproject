package myproject.collections.visitor;

abstract class Tree<E> {

	abstract public String toString();

	abstract public Double sum();

	public static <E> Tree<E> leaf(final E e) {
		return new Tree<E>() {

			@Override
			public String toString() {
				return e.toString();
			}

			@Override
			public Double sum() {
				return ((Double) e).doubleValue();
			}
		};
	}

	public static <E> Tree<E> branch(final Tree<E> l, final Tree<E> r) {
		return new Tree<E>() {

			@Override
			public String toString() {
				return "(" + l.toString() + "^" + r.toString() + ")";
			}

			@Override
			public Double sum() {
				return l.sum() + r.sum();
			}
		};
	}

	public static void main(String[] args) {
		Tree<Integer> t = Tree.branch(Tree.branch(Tree.leaf(1), Tree.leaf(2)), Tree.leaf(3));

		System.out.println(t);
	}

}
