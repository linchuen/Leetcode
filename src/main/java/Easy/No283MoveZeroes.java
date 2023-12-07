package Easy;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <p>
 * Note that you must do this in-place without making a copy of the array.
 */
public class No283MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int finalPosition = 0;
        for (int currentPosition = 0; currentPosition < nums.length; currentPosition++) {
            if (nums[currentPosition] != 0) {
                nums[finalPosition] = nums[currentPosition];
                finalPosition++;
            }
        }

        for (; finalPosition < nums.length; finalPosition++) {
            nums[finalPosition] = 0;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
