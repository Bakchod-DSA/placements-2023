/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/combinations/
 * Difficulty level: Medium
 */

package leetcode.Backtracking;

import java.util.*;

public class Problem77_Combinations {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tempList = new ArrayList<>();
        boolean[] box = new boolean[n];

        queenCombination1D(list, tempList, box, -1, 0, k);

//        queenCombination1DBoxRespect(list, tempList, box, 0, 0, k);

        return list;

    }

    public void queenCombination1D(List<List<Integer>> list, List<Integer> tempList, boolean[] box, int lastBoxUsed, int qpsf, int tq) {
        /*  Same as queen Combination 1D wrt box
            Approach: BackTracking
            Time Complexity: O(∑(n=1 to N) * n(n - 1)/2), for k = 1, n(n - 1)/2 calls.
            Space Complexity: O((k + 1) + 2k), k + 1 is the depth of the tree. k for templist, k for box.
            Explanation: qpsf -> queen placed so far, tq = k i.e. -> total queens to be placed, lastBoxUsed --> once a queen
                         placed in a box, we need other to sit after her and not include it further as its combination, no
                         importance to arrangements.
            Note:  we did not take into account the space needed to hold the results. Otherwise, the space complexity would become
                   O(n * nPn).
        */

        if(qpsf == tq) {
            list.add(new ArrayList<>(tempList));
            return;
        }

        for(int i = lastBoxUsed + 1; i < box.length; i++) {
            box[i] = true;
            tempList.add(i + 1);
            queenCombination1D(list, tempList, box, i, qpsf + 1, tq);
            tempList.remove(tempList.size() - 1);
            box[i] = false;
        }
    }

    public void queenCombination1DBoxRespect(List<List<Integer>> list, List<Integer> tempList, boolean[] box, int col, int qpsf, int tq) {
        if(qpsf == tq) {
            // +ve base case.
            list.add(new ArrayList<>(tempList));
            return;
        }
        if(col == box.length) {
            // -ve base case.
            return;
        }

        //placed
        box[col] = true;
        tempList.add(col + 1);
        queenCombination1DBoxRespect(list, tempList, box, col + 1, qpsf + 1, tq);

        //unplaced
        tempList.remove(tempList.size() - 1);
        box[col] = false;
        queenCombination1DBoxRespect(list, tempList, box, col + 1, qpsf, tq);
    }

}
