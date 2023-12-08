package Medium;

public class No33SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        if (target > nums[nums.length - 1] && target < nums[0]) return -1;
        return search(nums, target, 0, nums.length - 1);
    }

    public static int search(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] > nums[right]) {
            if (nums[mid] > target) {
                int result = normalSearch(nums, target, left, right, mid);
                if (result != -1) return result;
            }
            return search(nums, target, mid + 1, right);
        } else if (nums[mid] < nums[left]) {
            if (nums[mid] < target) {
                int result = normalSearch(nums, target, left, right, mid);
                if (result != -1) return result;
            }
            return search(nums, target, left, mid - 1);
        } else {
            return normalSearch(nums, target, left, right, mid);
        }
    }

    private static int normalSearch(int[] nums, int target, int left, int right, int mid) {
        if (nums[mid] < target) {
            if (mid + 1 > right) return -1;
            return search(nums, target, mid + 1, right);
        } else {
            if (mid - 1 < left) return -1;
            return search(nums, target, left, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int result = search(nums, 0);
        System.out.println(result);
    }
}
