package myproject;

public class Main6 {

	public static void main(final String[] args) {
//		final String apple = "APPLE";
//		
//		
//		System.out.printf("%s %s", apple.charAt(apple.length() -1), apple.charAt(apple.length() - 2));
		
		final int[] ints = {2, 3, 10, 2, 4, 8, 1};
		
		final int maxIndex = findMaxIndex(ints);
		final int minIndex = findMinIndexUntil(ints, maxIndex);
		
		System.out.println(ints[maxIndex] - ints[minIndex]);

	}

	private static int findMaxIndex(final int[] ints) {

		int maxIndex = 0;
		for (int i = 1; i < ints.length; i++) {
			final int num = ints[i];
			if ((num > ints[maxIndex])) {
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}
	
	private static int findMinIndexUntil(final int[] ints, final int maxIndex) {
		
		int minIndex = 0;
		for (int i = 1; i < maxIndex; i++) {
			final int num = ints[i];
			if ((num < ints[minIndex])) {
				minIndex = i;
			}
		}
		
		return minIndex;
	}

}
