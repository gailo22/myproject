package myproject.closure;

public class ExampleClients {
	
	static List<Integer> doubleAll(List<Integer> xs) {
		return List.map(new Func<Integer, Integer>() {
			
			@Override
			public Integer m(Integer x) {
				return x * 2;
			}
		}, xs);
	}

	static int countNs(List<Integer> xs, final int n) {
		return List.length(List.filter(new Pred<Integer>() {

			@Override
			public boolean m(Integer x) {
				return x == n;
			}
		}, xs));
	}
	
	static List<Integer> incThenDouble(List<Integer> xs) {
		Func2<Integer, Integer> inc = new Func2<Integer, Integer> () {

			@Override
			public List<Integer> m(Integer a) {
				return new List<>(a + 1, null);
			}
			
		};
		Func2<Integer, Integer> db =  new Func2<Integer, Integer> () {

			@Override
			public List<Integer> m(Integer a) {
				return new List<>(a * 2, null);
			}
			
		};
		
		return List.flatMap(db, List.flatMap(inc, xs));
	}
	
	static void print(List<Integer> xs) {
		if (xs == null) {
			System.out.println();
			return;
		}
		
		System.out.print(xs.head + ",");
		print(xs.tail);
	}
	
	public static void main(String[] args) {
		
		List<Integer> list1 = new List<>(1, new List<>(2, new List<>(3, new List<>(4, new List<>(5, null)))));
		
		List<Integer> doubleAll = doubleAll(list1);
		print(doubleAll);
		
		int countNs = countNs(list1, 5);
		System.out.println(countNs);
		
		List<Integer> incThenDouble = incThenDouble(list1);
		print(incThenDouble);
		
	}

}
