/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/path-sum-ii/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem113_PathSumII {

    List<List<Integer>> pathSums = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<Integer>());
        return pathSums;
    }

    private void dfs(TreeNode root, int targetSum, List<Integer> uniqueSum) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            if(targetSum - root.val == 0) {
                uniqueSum.add(root.val);
                pathSums.add(new ArrayList<>(uniqueSum));
                uniqueSum.remove(uniqueSum.size() - 1);
                return;
            }

        }

        uniqueSum.add(root.val);
        dfs(root.left, targetSum - root.val, uniqueSum);
        dfs(root.right, targetSum - root.val, uniqueSum);
        uniqueSum.remove(uniqueSum.size() - 1);
    }

}
