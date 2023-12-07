package Easy;

/**
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class No704BinarySearch {
    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private static int search(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] < target) {
            if (mid + 1 > right) return -1;
            return search(nums, target, mid + 1, right);
        } else {
            if (mid - 1 < left) return -1;
            return search(nums, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;

        int result = search(nums, target);
        assert result == 4;
    }


}
