/**
 * Author : Sradha Kedia
 * Page no.: 242 of Epi Java
 * Problem no.: 14.5
 * Difficulty level : Medium
 */
package EPI.Sorting;

import java.util.ArrayList;
import java.util.List;

public class Problem14_5_MergeIntervals {

    public static class Interval {
        public int left, right;

        public Interval(int l, int r) {
            this.left = l;
            this.right = r;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            Interval interval = (Interval)o;

            if (left != interval.left) {
                return false;
            }
            return right == interval.right;
        }

        @Override
        public String toString() {
            return "[" + left + ", " + right + "]";
        }
    }

    public static List<Interval> addInterval(List<Interval> disjointIntervals,
                                             Interval newInterval) {
        List<Interval> mergeIntervals = new ArrayList<>();
        for(int i = 0; i < disjointIntervals.size(); i++) {
            Interval curr = disjointIntervals.get(i);
            int val = isDisjoint(curr, newInterval);
            if(val ==  -1) {
                // curr is smaller, add it.
                mergeIntervals.add(curr);
            } else if(val == 1) {
                // curr is greater, means add newInterval and rest of intervals from input as it is to get the final required list.
                mergeIntervals.add(newInterval);
                mergeIntervals.addAll(disjointIntervals.subList(i, disjointIntervals.size()));
                break;
            } else {
                // overlapping intervals, merge them.
                newInterval.left = Math.min(disjointIntervals.get(i).left, newInterval.left);
                newInterval.right = Math.max(disjointIntervals.get(i).right, newInterval.right);
            }
        }
        // check if newInterval is in mergeIntervals. if not, means it is greatest and is not added till now and needs to be
        // added at the end.
        if(!mergeIntervals.contains(newInterval)) mergeIntervals.add(newInterval);
        return mergeIntervals;
    }
    private static int isDisjoint(Interval oldI, Interval newI) {
        if(oldI.left < newI.left && oldI.right < newI.left) return -1; // oldI is smaller
        if(newI.left < oldI.left && newI.right < oldI.left) return 1; // newI is smaller
        else return 0; // not disjoint, can be merged
    }
}
