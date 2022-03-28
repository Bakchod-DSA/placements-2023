/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/symmetric-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

public class Problem101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        return root == null || checkSymmetric(root.left, root.right);
    }

    private boolean checkSymmetric(TreeNode subtree0, TreeNode subtree1) {
        /*  Approach: dfs
            Time Complexity: O(n)
            Space Complexity: O(h), height of the tree
        */

        if((subtree0 == null && subtree1 != null) || (subtree0 != null && subtree1 == null)) {
            return false;
        }
        if(subtree0 == null && subtree1 == null) {
            return true;
        }
        else { // subtree0 != null && subtrre1 != null
            return subtree0.val == subtree1.val && checkSymmetric(subtree0.left, subtree1.right) && checkSymmetric(subtree0.right, subtree1.left);
        }
    }

}
