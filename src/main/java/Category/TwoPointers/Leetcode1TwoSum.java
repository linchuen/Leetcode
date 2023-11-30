package Category.TwoPointers;

import java.util.HashMap;
import java.util.Map;

public class Leetcode1TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int left = 0; left < nums.length - 2; left++) {
            for (int right = left + 1; right < nums.length - 1; right++) {
                int leftNum = nums[left];
                int rightNum = nums[right];
                if (leftNum + rightNum == target) return new int[]{left, right};
            }
        }
        return new int[]{};
    }

    public int[] twoSumV2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int search = target - nums[i];

            Integer index = numMap.get(search);
            if (index != null) {
                return new int[]{i, index};
            }

            numMap.put(nums[i], i);
        }
        return new int[]{};
    }
}
