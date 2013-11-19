package myproject.collections;

import java.util.Iterator;

public class Counter implements Iterable<Integer> {

	private int count;

	public Counter(int count) {
		this.count = count;
	}

	public static void main(String[] args) {

		for (int c : new Counter(10)) {
			System.out.println(c);
		}

	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer>() {
			private int i = 0;

			@Override
			public boolean hasNext() {
				return i < count;
			}

			@Override
			public Integer next() {
				i++;
				return i;
			}

			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
	}

}
