package Category.Sort;

import java.util.*;

public class Leetcode56MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        sortIntervals(intervals);
        List<int[]> intervalList = new LinkedList<>();
        int index = 0;
        while (index < intervals.length) {
            int[] baseInterval = intervals[index];
            index = mergeBaseInterval(intervals, index);
            intervalList.add(baseInterval);
        }
        int[][] mergeIntervals = new int[intervalList.size()][2];
        int i = 0;
        for (int[] interval : intervalList) {
            mergeIntervals[i] = interval;
            i++;
        }
        return mergeIntervals;
    }

    private static int mergeBaseInterval(int[][] intervals, int index) {
        int[] baseInterval = intervals[index];
        for (int i = index + 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            int baseEnd = baseInterval[1];
            int start = interval[0];
            int end = interval[1];

            if (baseEnd < start) {
                return i;
            }

            if (baseEnd < end) {
                baseInterval[1] = end;
            }
        }
        return intervals.length;
    }

    private static void sortIntervals(int[][] intervals) {
        TreeMap<Integer, int[]> intervalMap = new TreeMap<>();
        for (int[] interval : intervals) {
            intervalMap.compute(interval[0], (k, v) -> {
                if (v == null) return interval;

                interval[1] = Math.max(interval[1], v[1]);
                return interval;
            });
        }

        int index = 0;
        for (int[] value : intervalMap.values()) {
            intervals[index] = value;
            index++;
        }
    }

    public static void main(String[] args) {
        int[][] intervals = {{2, 3}, {5, 5}, {2, 2}, {3, 4}, {3, 4}};
//        int[][] intervals = {{2, 6}, {8, 10}, {1, 3}, {15, 18}};

        for (int[] interval : intervals) {
            System.out.println(interval[0] + " " + interval[1]);
        }
        System.out.println();

//        int[][] mergeIntervals = merge(intervals);
//        for (int[] interval : mergeIntervals) {
//            System.out.println(interval[0] + " " + interval[1]);
//        }

        int[][] mergePairs = mergeWithPair(intervals);
        for (int[] interval : mergePairs) {
            System.out.println(interval[0] + " " + interval[1]);
        }
    }

    private static List<Pair> sortIntervalsWithPair(int[][] intervals) {
        List<Pair> result = new ArrayList<>();
        for (int[] interval : intervals) {
            result.add(new Pair(interval[0], interval[1]));
        }
        result.sort((p1, p2) -> {
            if (p1.x < p2.x) return -1;
            if (p1.x > p2.x) return 1;
            return Integer.compare(p1.y, p2.y);
        });
        return result;
    }

    private static int mergeBaseIntervalWithPair(List<Pair> intervals, int index) {
        Pair baseInterval = intervals.get(index);
        for (int i = index + 1; i < intervals.size(); i++) {
            Pair interval = intervals.get(i);

            if (baseInterval.x == interval.x) {
                baseInterval.y = Math.max(baseInterval.y, interval.y);
            }

            if (baseInterval.y < interval.x) {
                return i;
            }

            if (baseInterval.y < interval.y) {
                baseInterval.y = interval.y;
            }
        }
        return intervals.size();
    }

    public static int[][] mergeWithPair(int[][] intervals) {
        List<Pair> pairList = sortIntervalsWithPair(intervals);
        List<int[]> intervalList = new LinkedList<>();
        int index = 0;
        while (index < pairList.size()) {
            Pair baseInterval = pairList.get(index);
            index = mergeBaseIntervalWithPair(pairList, index);
            intervalList.add(new int[]{baseInterval.x, baseInterval.y});
        }
        int[][] mergeIntervals = new int[intervalList.size()][2];
        int i = 0;
        for (int[] interval : intervalList) {
            mergeIntervals[i] = interval;
            i++;
        }
        return mergeIntervals;
    }

    public static class Pair {
        public int x;
        public int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}


