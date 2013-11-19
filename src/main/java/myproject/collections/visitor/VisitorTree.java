package myproject.collections.visitor;

abstract class VisitorTree<E> {

	public interface Visitor<E, R> {
		R leaf(E elt);

		R branch(R left, R right);
	}

	public abstract <R> R visit(Visitor<E, R> v);

	public static <T> VisitorTree<T> leaf(final T e) {
		return new VisitorTree<T>() {

			@Override
			public <R> R visit(Visitor<T, R> v) {
				return v.leaf(e);
			}
		};
	}

	public static <T> VisitorTree<T> branch(final VisitorTree<T> l, final VisitorTree<T> r) {
		return new VisitorTree<T>() {

			@Override
			public <R> R visit(Visitor<T, R> v) {
				return v.branch(l.visit(v), r.visit(v));
			}
		};
	}

}
