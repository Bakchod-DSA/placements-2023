// https://leetcode.com/problems/merge-intervals/
package leetcode.Greedy;

import java.util.*;

public class Problem56_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        /*  Approach: matrix, sorting
            Time Complexity: O(n logn + n), n logn for sorting and n for traversing to merge.
            Space Complexity: O(mn)
        */
        int n = intervals.length;
        List<int[]> mergedIntervals = new ArrayList<>();

        Arrays.sort(intervals, (r1, r2) -> r1[0] - r2[0]);
        for(int i = 0; i < n - 1; i++) {
            int val = compareTo(intervals[i], intervals[i + 1]);
            if(val == -1) {
                // if val = -1, interval[i] is smaller than interval[i + 1] => disjoint
                mergedIntervals.add(intervals[i]);
            } else {
                // else, overlapping and can be merged
                intervals[i + 1] = findMergedInterval(intervals[i], intervals[i + 1]);
            }
        }
        if(!mergedIntervals.contains(intervals[n - 1])) {
            mergedIntervals.add(intervals[n - 1]);
        }

        return formAnswer(mergedIntervals);
    }

    private int compareTo(int[] interval1, int[] interval2) {
        if(interval1[1] < interval2[0]) return -1;
        return 0;
    }

    private int[] findMergedInterval(int[] interval1, int[] interval2) {
        int[] mergedInterval = new int[2];
        mergedInterval[0] = Math.min(interval1[0], interval2[0]);
        mergedInterval[1] = Math.max(interval1[1], interval2[1]);
        return mergedInterval;
    }

    private int[][] formAnswer(List<int[]> mergedIntervals) {
        int m = mergedIntervals.size();
        int[][] newMergedIntervals = new int[m][0];
        for(int i = 0; i < m; i++) {
            newMergedIntervals[i] = mergedIntervals.get(i);
        }
        return newMergedIntervals;
    }
}
