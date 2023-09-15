package TwoPointers;

public class Leetcode167TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        for (int left = 0; left < numbers.length - 1; left++) {
            int right = numbers.length - 1;
            int search = target - numbers[left];

            int index = binarySearch(numbers, search, left + 1, right);
            if (index != -1) return new int[]{left + 1, index + 1};
        }
        return new int[]{};
    }

    private static int binarySearch(int[] numbers, int target, int l, int r) {
        int mid = (l + r) / 2;
        if (r < l) return -1;

        if (numbers[mid] < target) {
            return binarySearch(numbers, target, mid + 1, r);
        } else if (numbers[mid] > target) {
            return binarySearch(numbers, target, l, mid - 1);
        } else {
            return mid;
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(numbers, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
