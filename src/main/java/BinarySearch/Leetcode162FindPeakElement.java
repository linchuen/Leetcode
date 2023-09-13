package BinarySearch;

public class Leetcode162FindPeakElement {
    public static int findPeakElement(int[] nums) {
        int total = nums.length;
        if (total == 1) return 0;
        return findPeakElement(nums, 0, total - 1);
    }

    public static int findPeakElement(int[] nums, int left, int right) {
        int index = (left + right) / 2;

        boolean isPeak = isPeak(nums, index);
        if (isPeak) return index;
        if (left == right) return -1;

        if (nums[index] <= nums[index + 1]) {
            return findPeakElement(nums, index + 1, right);
        }
        if (nums[index] <= nums[index - 1]) {
            return findPeakElement(nums, left, index - 1);
        }
        return -1;
    }

    private static boolean isPeak(int[] nums, int index) {
        if (index == 0)
            return nums[index] > nums[index + 1];
        if (index == nums.length - 1)
            return nums[index] > nums[index - 1];

        return nums[index] > nums[index + 1] && nums[index] > nums[index - 1];
    }

    public static void main(String[] args) {
//        List<Integer> integerList = Instancio.ofList(Integer.class).size(20).create();
//        int[] nums = integerList.stream().mapToInt(i -> i).toArray();

        int[] nums = {1, 2};
        int index = findPeakElement(nums);
        System.out.println("index = " + index);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
