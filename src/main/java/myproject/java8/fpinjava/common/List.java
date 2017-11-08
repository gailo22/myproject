package myproject.java8.fpinjava.common;

public abstract class List<A> {

	protected abstract A head();
	protected abstract List<A> tail();
	protected abstract List<A> take(int n);
	public abstract boolean isEmpty();
	public abstract List<A> setHead(A h);
	public abstract List<A> drop(int n);
	public abstract List<A> dropWhile(Function<A, Boolean> f);
	public abstract List<A> reverse();
	public abstract List<A> init();
	public abstract int length();
	public abstract <B> B foldLeft(B identity, Function<B, Function<A, B>> f);
	public abstract <B> Tuple<B, List<A>> foldLeft(B identity, B zero, Function<B, Function<A, B>> f);
	public abstract <B> B foldRight(B identity, Function<A, Function<B, B>> f);
	public abstract <B> List<B> map(Function<A, B> f);
	public abstract List<A> filter(Function<A, Boolean> f);
	public abstract <B> List<B> flatMap(Function<A, List<B>> f);
	public abstract A reduce(Function<A, Function<A, A>> f);
	public abstract Result<A> headOption();
	public abstract Result<List<A>> tailOption();
	public abstract String mkStr(String sep);
	public abstract <B> Result<List<B>> sequence(Function<A, Result<B>> f);
	public abstract List<A> takeAtMost(int n);
	public abstract List<A> takeWhile(Function<A, Boolean> p);
	public abstract List<List<A>> subLists();
	public abstract List<List<A>> interleave(A a);
	public abstract List<List<A>> perms();
	public abstract List<Tuple<List<A>, List<A>>> split();
	public abstract Result<Tuple<A, List<A>>> headAndTail();
	public abstract Stream<A> toStream();
	
	private static class Cons<A> extends List<A> {

		private final A head;
		private final List<A> tail;
		private final int length;

		private Cons(A head, List<A> tail) {
			this.head = head;
			this.tail = tail;
			this.length = tail.length() + 1;
		}

		public A head() {
			return head;
		}

		public List<A> tail() {
			return tail;
		}

		public boolean isEmpty() {
			return false;
		}

		@Override
		protected List<A> take(int n) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> setHead(A h) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> drop(int n) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> dropWhile(Function<A, Boolean> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> reverse() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> init() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int length() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <B> B foldLeft(B identity, Function<B, Function<A, B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> Tuple<B, List<A>> foldLeft(B identity, B zero, Function<B, Function<A, B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> B foldRight(B identity, Function<A, Function<B, B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> List<B> map(Function<A, B> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> filter(Function<A, Boolean> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> List<B> flatMap(Function<A, List<B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public A reduce(Function<A, Function<A, A>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<A> headOption() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<List<A>> tailOption() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String mkStr(String sep) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> Result<List<B>> sequence(Function<A, Result<B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> takeAtMost(int n) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> takeWhile(Function<A, Boolean> p) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<List<A>> subLists() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<List<A>> interleave(A a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<List<A>> perms() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Tuple<List<A>, List<A>>> split() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<Tuple<A, List<A>>> headAndTail() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Stream<A> toStream() {
			// TODO Auto-generated method stub
			return null;
		}
	}

	private static class Nil<A> extends List<A> {

		private Nil() {}

		public A head() {
			throw new IllegalStateException("head called en empty list");
		}

		public List<A> tail() {
			throw new IllegalStateException("tail called en empty list");
		}

		public boolean isEmpty() {
			return true;
		}

		@Override
		protected List<A> take(int n) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> setHead(A h) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> drop(int n) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> dropWhile(Function<A, Boolean> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> reverse() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> init() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int length() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public <B> B foldLeft(B identity, Function<B, Function<A, B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> Tuple<B, List<A>> foldLeft(B identity, B zero, Function<B, Function<A, B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> B foldRight(B identity, Function<A, Function<B, B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> List<B> map(Function<A, B> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> filter(Function<A, Boolean> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> List<B> flatMap(Function<A, List<B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public A reduce(Function<A, Function<A, A>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<A> headOption() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<List<A>> tailOption() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String mkStr(String sep) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <B> Result<List<B>> sequence(Function<A, Result<B>> f) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> takeAtMost(int n) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<A> takeWhile(Function<A, Boolean> p) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<List<A>> subLists() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<List<A>> interleave(A a) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<List<A>> perms() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Tuple<List<A>, List<A>>> split() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Result<Tuple<A, List<A>>> headAndTail() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Stream<A> toStream() {
			// TODO Auto-generated method stub
			return null;
		}
	}
}
