package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class No39CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        getSumResult(candidates, target, candidates[0], new Stack<>(), result);
        return result;
    }

    private static void getSumResult(int[] candidates, int target, int currentValue, Stack<Integer> stack, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(stack));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int candidate : candidates) {
            if (candidate < currentValue) continue;

            stack.push(candidate);
            getSumResult(candidates, target - candidate, candidate, stack, result);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = new ArrayList<>();
        getSumResult(nums, 6, 1, new Stack<>(), result);
        result.forEach(System.out::println);
    }
}
