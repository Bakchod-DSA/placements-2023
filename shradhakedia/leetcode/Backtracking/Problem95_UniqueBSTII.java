/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/unique-binary-search-trees-ii/
 * Difficulty level: Medium
 */

package leetcode.Backtracking;

import java.util.*;

public class Problem95_UniqueBSTII {

    public List<TreeNode> generateTrees(int n) {
        return computeBSTs(1, n);
    }

    private List<TreeNode> computeBSTs(int minVal, int maxVal) {
        /*  Approach: recursion/backTracking
            Time Complexity:  The number of total trees is a Catalan Number, then its time complexity should be
                              O((2n)!/((n+1)!*n!)).
            Space Complexity: don't know :)
        */

        List<TreeNode> bsts = new ArrayList<>();
        if(minVal > maxVal) {
            bsts.add(null);
            return bsts;
        }

        for(int i = minVal; i <= maxVal; i++) {
            List<TreeNode> leftTrees = computeBSTs(minVal, i - 1);
            List<TreeNode> rightTrees = computeBSTs(i + 1, maxVal);

            for(TreeNode left : leftTrees)  {
                for(TreeNode right : rightTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    bsts.add(node);
                }
            }
        }

        return bsts;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
