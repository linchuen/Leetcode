package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class No1TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numLocMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int findValue = target - nums[i];

            Integer findLoc = numLocMap.get(findValue);
            if (findLoc == null) {
                numLocMap.put(nums[i], i);
            } else {
                return new int[]{i, findLoc};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = twoSum(nums, target);
        assert Arrays.equals(result, new int[]{1, 2});
    }
}
