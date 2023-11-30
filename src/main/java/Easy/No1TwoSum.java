package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1TwoSum {

    public int[] twoSum(int[] nums, int target) {
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
        No1TwoSum no1TwoSum = new No1TwoSum();

        int[] nums= {3,2,4};
        int target = 6;
        int[] result=no1TwoSum.twoSum(nums,target);
        assert Arrays.equals(result, new int[]{1, 2});
    }
}
