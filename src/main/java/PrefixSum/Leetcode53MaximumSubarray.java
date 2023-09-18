package PrefixSum;

public class Leetcode53MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        int[] prefixSumArray = new int[nums.length];
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            prefixSumArray[i] = prefixSum;
        }
        int max = nums[0];
        for (int i = 0; i < prefixSumArray.length; i++) {
            for (int j = 0; j < i; j++) {
                int sum = prefixSumArray[i] - prefixSumArray[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

    public static int maxSubArrayV2(int[] nums) {
        int max = nums[0];
        int preMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preMax = Math.max(nums[i] + preMax, nums[i]);
            max = Math.max(max, preMax);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        int max = maxSubArrayV2(nums);
        System.out.println("max = " + max);
    }
}
