package myproject.interview;

import java.util.Arrays;

public class MoveZeroes {
	
	static void moveZeroes(int[] nums) {
		if (nums == null || nums.length == 0)  return;
		
		int index = 0;
		for (int num : nums) {
			if (num != 0) {
				nums[index++] = num;
			}
		}
		
		while(index < nums.length) {
			nums[index++] = 0;
		}
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		int[] nums = {0, 1, 0, 3, 12};
		System.out.println(Arrays.toString(nums));
		moveZeroes(nums);
		System.out.println(Arrays.toString(nums));
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
}
