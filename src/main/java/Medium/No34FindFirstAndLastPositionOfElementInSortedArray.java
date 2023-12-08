package Medium;

import java.util.Arrays;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 * <p>
 * If target is not found in the array, return [-1, -1].
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class No34FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target, 0, nums.length - 1);
        if (index == -1) return new int[]{-1, -1};

        int leftIndex = index;
        while (nums[leftIndex] == target) {
            leftIndex--;
            if (leftIndex < 0) break;
        }
        int rightIndex = index;
        while (nums[rightIndex] == target) {
            rightIndex++;

            if (rightIndex >= nums.length) break;
        }
        return new int[]{leftIndex + 1, rightIndex - 1};
    }

    private static int binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;

        if (nums[mid] < target) {
            return binarySearch(nums, target, mid + 1, right);
        } else {
            return binarySearch(nums, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {8,8,8,8};
        int[] result = searchRange(nums, 8);
        System.out.println(Arrays.toString(result));
    }
}
