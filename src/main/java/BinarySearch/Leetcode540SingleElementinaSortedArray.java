package BinarySearch;

public class Leetcode540SingleElementinaSortedArray {

    public static int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return 0;
        return findNonDuplicateElement(nums, 0, nums.length - 1);
    }

    public static int findNonDuplicateElement(int[] nums, int left, int right) {
        int index = (left + right) / 2;
        System.out.println(left + " : " + right);
        System.out.println(nums[index] + " index: " + index);

        boolean isDuplicate = isDuplicate(nums, index);
        System.out.println("isDuplicate = " + isDuplicate);
        if (!isDuplicate) return index;
        if (left == right || index == nums.length-1 || index == 0) return -1;

        int leftResult = findNonDuplicateElement(nums, index + 1, right);
        int rightResult = findNonDuplicateElement(nums, left, index - 1);
        return leftResult == -1 ? rightResult : leftResult;
    }

    private static boolean isDuplicate(int[] nums, int index) {
        if (index == 0)
            return nums[index] == nums[index + 1];
        if (index == nums.length - 1)
            return nums[index] == nums[index - 1];

        return nums[index] == nums[index + 1] || nums[index] == nums[index - 1];
    }

    private static int findDuplicateIndex(int[] nums, int index) {
        if (index == 0 && nums[0] == nums[1])
            return 1;
        if (index == nums.length - 1 && nums[index] == nums[index - 1])
            return index - 1;

        if (nums[index] == nums[index + 1]) return index + 1;
        if (nums[index] == nums[index - 1]) return index - 1;
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        int index = singleNonDuplicate(nums);
        System.out.println("index = " + index);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
