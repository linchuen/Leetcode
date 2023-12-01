package Easy;

/**
 * Given an array nums of size n, return the majority element.
 * <p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
public class No169MajorityElement {

    public static int majorityElement(int[] nums) {
        int majority = nums[0];
        int pairValue = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == majority) {
                pairValue++;
            } else {
                pairValue--;
                boolean isNeedReverse = pairValue < 0;
                if (isNeedReverse) {
                    pairValue = 1;
                    majority = nums[i];
                }
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        int majority = majorityElement(nums);
        System.out.println(majority);
    }
}
