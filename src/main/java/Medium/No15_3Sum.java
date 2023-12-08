package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No15_3Sum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        int negativeBoundary = -1;
        List<List<Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length && nums[i] < 0; i++) {
            negativeBoundary = i;

            int negative = nums[i];
            if (i > 0 && negative == nums[i - 1]) continue;

            for (int j = nums.length - 1; nums[j] > 0; j--) {
                int positive = nums[j];
                if (j < nums.length - 1 && positive == nums[j + 1]) continue;

                int target = -(negative + positive);
                Integer thirdValueIndex = binarySearch(nums, target, i + 1, j - 1);
                if (thirdValueIndex != null) {
                    int thirdValue = nums[thirdValueIndex];
                    resultList.add(List.of(negative, thirdValue, positive));
                }
            }
        }
        if (nums.length > negativeBoundary + 3 &&
                nums[negativeBoundary + 1] == 0 &&
                nums[negativeBoundary + 2] == 0 &&
                nums[negativeBoundary + 3] == 0) {
            resultList.add(List.of(0, 0, 0));
        }
        return resultList;
    }

    private static Integer binarySearch(int[] nums, int target, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) / 2;

        if (nums[mid] == target) return mid;

        if (nums[mid] < target) {
            if (mid + 1 > right) return null;
            return binarySearch(nums, target, mid + 1, right);
        } else {
            if (mid - 1 < left) return null;
            return binarySearch(nums, target, left, mid - 1);
        }
    }

    public List<List<Integer>> threeSumV2(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int len = nums.length;

        Arrays.sort(nums);

        for(int i=0; i<len; i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int left = i+1;
            int right = len-1;
            while(left<right){
                int sum = nums[i]+nums[left]+nums[right];

                if(sum<0) {
                    left++;
                }
                else if(sum>0) {
                    right--;
                }
                else{
                    answer.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while((left < right) && nums[left]==nums[left-1]) left++;
                    while((left < right) && nums[right]==nums[right+1]) right--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, -2, 3, -2, -5, 4, -1, -5, 4};
        threeSum(nums).forEach(System.out::println);
    }
}
