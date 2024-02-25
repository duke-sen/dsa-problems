package dsa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        // Sorting the arrays
        Arrays.sort(intervals, Comparator.comparingInt(ele -> ele[0]));
        List<int[]> mergedIntervals = new ArrayList<>();


        for (int i = 1; i < intervals.length; i++) {
            int previousStart = intervals[i - 1][0];
            int previousEnd = intervals[i - 1][1];
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (previousStart <= currentStart && previousEnd >= currentStart) {
                intervals[i][0] = previousStart;
                intervals[i][1] = Math.max(previousEnd, currentEnd);
            }
            else {
                mergedIntervals.add(intervals[i - 1]);
            }
        }
        mergedIntervals.add(intervals[intervals.length - 1]);
        return mergedIntervals.toArray(int[][]::new);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(new MergeIntervals().merge(intervals)));
    }
}
