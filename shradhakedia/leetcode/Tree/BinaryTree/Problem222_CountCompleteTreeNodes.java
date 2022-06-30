/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/count-complete-tree-nodes/
 * Difficulty level: Medium
 */
package leetcode.Tree.BinaryTree;

public class Problem222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        int h = height(root);
        if(h < 0) return 0;

        int rt = height(root.right);
        if(rt + 1 == h) {
            // lt tree is full BT of height h - 1, so total nodes = no. of nodes in left + root + no. of nodes in right that we
            // find recursively. no. of nodes in left (2 ^ h - 1).
            return (1 << h) + countNodes(root.right);
        } else {
            // rt tree is full BT of height h - 2, so total nodes = no. of nodes in right + root + no. of nodes in left that we
            // find recursively. no. of nodes in right (2 ^ (h - 1) - 1).
            return (1 << h - 1) + countNodes(root.left);
        }

    }

    private int height(TreeNode root) {
        if(root == null) return -1;

        int h = height(root.left);
        return 1 + h;
    }
}
