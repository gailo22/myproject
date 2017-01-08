package myproject.dp.bridge8;

import java.util.NoSuchElementException;

public class MyLists {

	public static int sum(MyList<Integer> list) {
		return sumRec(list, 0);
	}

	private static Integer sumRec(MyList<Integer> list, Integer acc) {
		if (list.isEmpty()) {
			return acc;
		} else {
			return list.head() + sumRec(list.tail(), acc);
		}
	}

	private static class Cons implements MyList<Integer> {

		private Integer head;
		private MyList<Integer> tail;

		Cons(int head, MyList<Integer> tail) {
			this.head = head;
			this.tail = tail;
		}

		@Override
		public Integer head() {
			return head;
		}

		@Override
		public MyList<Integer> tail() {
			return tail;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}
	}

	private static class Nil implements MyList<Integer> {

		@Override
		public Integer head() {
			throw new NoSuchElementException();
		}

		@Override
		public MyList<Integer> tail() {
			throw new NoSuchElementException();
		}

		@Override
		public boolean isEmpty() {
			return true;
		}
	}

	public static void main(String[] args) {

		MyList<Integer> list = new Cons(1, new Cons(2, new Cons(3, new Cons(4, new Cons(5, new Nil())))));

		int sum = MyLists.sum(list);
		System.out.println(sum);
	}

}
