package Category.TwoPointers;

import java.util.Random;
import java.util.stream.IntStream;

public class Leetcode283MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int zeroIndex = nums.length;

        int pos = nums.length - 1;
        while (pos >= 0) {
            if (nums[pos] == 0) {
                zeroIndex--;

                int tempPos = pos;
                while (tempPos < zeroIndex) {
                    nums[tempPos] = nums[tempPos + 1];
                    tempPos++;
                }
                nums[zeroIndex] = 0;
            }
            pos--;
        }
    }

    public static void moveZeroesV2(int[] nums) {
        int slow = -1;

        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                slow++;
                nums[slow] = nums[fast];
            }
        }
        for (int i = slow + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        int[] nums = IntStream.range(0, 15).boxed().mapToInt(i -> random.nextInt(5)).toArray();
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
        moveZeroesV2(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
