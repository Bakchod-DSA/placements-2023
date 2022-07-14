// https://www.interviewbit.com/problems/disjoint-intervals/
package leetcode.Greedy;

import java.util.*;

public class Problem_DisjointIntervals {
    public int solve(ArrayList<ArrayList<Integer>> A) {
        Collections.sort(A, (l1, l2) -> (l1.get(0) == l2.get(0))? l1.get(1) - l2.get(1) : l1.get(0) - l2.get(0));

        ArrayList<Integer> past = A.get(0);
        int disjointSets = 1;
        for(int i = 1; i < A.size(); i++) {
            ArrayList<Integer> curr = A.get(i);
            if(checkOverlap(past, curr)) {
                if(past.get(1) > curr.get(1)) past = curr;
            } else {
                disjointSets++;
                past = curr;
            }
        }

        return disjointSets;
    }

    private boolean checkOverlap(ArrayList<Integer> l1, ArrayList<Integer> l2) {
        if(l1.get(1) >= l2.get(0)) return true;
        else return false;
    }
}
