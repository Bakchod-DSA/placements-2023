/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/validate-binary-search-tree/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem98_ValidateBST {

    public boolean isValidBST(TreeNode root) {
        // return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return inorder(root);
    }

    private boolean dfs(TreeNode root, long minRange, long maxRange) {
        /*  Approach: dfs
            Time Complexity: O(n)
            Space Complexity: O(h)
        */

        if(root == null) {
            return true;
        }
        if(root.val >= maxRange || root.val <= minRange) {
            return false;
        }
        return dfs(root.left, minRange, root.val) && dfs(root.right, root.val, maxRange);

    }

    private boolean inorder(TreeNode root) {
        /*  Approach: dfs + iterative
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            TreeNode curr = stack.pop();
            if(pre != null && curr.val <= pre.val) {
                //not sorted
                return false;
            }
            pre = curr;
            root = curr.right;
        }

        return true;
    }

}
