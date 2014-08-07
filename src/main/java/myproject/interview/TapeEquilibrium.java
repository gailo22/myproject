package myproject.interview;

public class TapeEquilibrium {
	public static void main(String[] args) {

		int[] a = new int[] { 3, 1, 2, 4, 3 };

		System.out.println(solution(a));
	}

	public static int solution(int[] A) {

		long sumright = 0;
		long sumleft = 0;
		long ans;

		for (int i = 1; i < A.length; i++) {
			sumright += A[i];
		}

		sumleft = A[0];
		ans = Math.abs(Math.abs(sumright) + Math.abs(sumleft));

		for (int P = 1; P < A.length; P++) {
			long abs = Math.abs(sumleft - sumright);
			if (abs < ans) {
				ans = abs;
			}
			sumleft += A[P];
			sumright -= A[P];
		}
		return (int) ans;
	}
}
