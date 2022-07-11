/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/balanced-binary-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

public class Problem110_BalancedBinaryTree {

    public boolean result = true;

    public boolean isBalanced(TreeNode root) {
        height(root);
        return result;
    }

    private int height(TreeNode root) {
        /*  Approach: dfs
            Time Complexity: O(n)
            Space Complexity: O(h), height of the tree due to recursive stack
        */

        if(root == null) {
            return 0;
        }
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1) {
            result = false;
        }
        return Math.max(left, right) + 1;
    }

}
