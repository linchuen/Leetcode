package Medium;

public class No33SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (target > nums[nums.length - 1] && target < nums[0]) return -1;
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int left, int right) {
        if (left > right) return -1;

        int mid = (left + right) / 2;
        if (nums[mid] == target) return mid;

        if (nums[mid] > nums[right]) {
            if (nums[mid] > target) {
                int leftResult = search(nums, target, left, mid - 1);
                if (leftResult != -1) return leftResult;
            }
            return search(nums, target, mid + 1, right);
        } else if (nums[mid] < nums[left]) {
            if (nums[mid] < target) {
                int rightResult = search(nums, target, mid + 1, right);
                if (rightResult != -1) return rightResult;
            }
            return search(nums, target, left, mid - 1);
        } else if (nums[mid] < target) {
            return search(nums, target, mid + 1, right);
        } else {
            return search(nums, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int result = search(nums, 0);
        System.out.println(result);
    }
}
