/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/path-sum/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

public class Problem112_PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    private boolean dfs(TreeNode root, int targetSum, int sum) {
        if(root == null) {
            return false;
        }
        if(root.right == null && root.left == null) {
            return sum + root.val == targetSum;
        }

        boolean leftPath = dfs(root.left, targetSum, sum + root.val);
        boolean rightPath = dfs(root.right, targetSum, sum + root.val);
        return  leftPath || rightPath;

    }

}
