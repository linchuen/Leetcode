package Category.Sort;

import java.util.Random;
import java.util.stream.IntStream;

public class Leetcode27RemoveElements {

    public static int removeElement(int[] nums, int val) {
        int end = nums.length - 1;
        int index = end;
        int validCount = 0;

        while (index >= 0) {
            if (nums[index] == val) {
                int temp = nums[end - validCount];
                nums[end - validCount] = nums[index];
                nums[index] = temp;
                validCount++;
            }
            index--;
        }
        return nums.length - validCount;
    }

    public static void main(String[] args) {
        int[] nums = IntStream.range(0, 10).map(i -> new Random().nextInt(5)).toArray();
//        int[] nums = {2, 3, 2, 3};
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();

        int k = removeElement(nums, 2);
        System.out.println(k);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
