package Easy;

/**
 * Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 * <p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class No35SearchInsertPosition {

    public static int searchInsert(int[] nums, int target) {
        int result = binarySearch(nums, target, 0, nums.length - 1);
        return result == -1 ? 0 : result;
    }

    public static int binarySearch(int[] nums, int target, int leftBound, int rightBound) {
        if (leftBound >= rightBound) return target > nums[leftBound] ? leftBound + 1 : leftBound ;

        int mid = (leftBound + rightBound) / 2;
        if (target == nums[mid]) return mid;

        if (target < nums[mid]) {
            return binarySearch(nums, target, leftBound, mid - 1);
        }

        if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, rightBound);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
        System.out.println(searchInsert(nums, 7));
        System.out.println(searchInsert(nums, 2));
        System.out.println(searchInsert(nums, 0));

        int[] nums2 = {1, 3};
        System.out.println(searchInsert(nums2, 0));
        System.out.println(searchInsert(nums2, 2));
        System.out.println(searchInsert(nums2, 4));
    }
}
