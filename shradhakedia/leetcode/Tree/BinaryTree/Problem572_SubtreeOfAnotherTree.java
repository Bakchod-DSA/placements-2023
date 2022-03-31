/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/subtree-of-another-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

public class Problem572_SubtreeOfAnotherTree {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null) {
            return false;
        }

        if(isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null) {
            return true;
        }

        if(root == null || subRoot == null) {
            return false;
        }

        if(root.val == subRoot.val) {
            boolean lt = isSameTree(root.left, subRoot.left);
            boolean rt = isSameTree(root.right, subRoot.right);
            return lt && rt;
        }

        return false;
    }
}
