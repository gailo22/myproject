package myproject.interview;

public class GreatestSumOfSubArray {

	public static void main(String[] args) {

		int[] ar = { 1, -2, 3, 10, -4, 7, 2, -5 };

		int greatestSum = getGreatestSumOfSubArray(ar);

		System.out.println("greatestSum: " + greatestSum);
	}

	private static int getGreatestSumOfSubArray(int[] ar) {
		int currSum = 0;
		int greatestSum = Integer.MIN_VALUE;
		for (int i = 0; i < ar.length; i++) {
			if (currSum <= 0) {
				currSum = ar[i];
			} else {
				currSum += ar[i];
			}

			if (currSum > greatestSum) {
				greatestSum = currSum;
			}
		}

		return greatestSum;
	}

}
