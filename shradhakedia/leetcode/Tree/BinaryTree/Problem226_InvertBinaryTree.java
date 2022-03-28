/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/invert-binary-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

public class Problem226_InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        /*  Approach: dfs + recursive
            Time Complexity: O(n)
            Space Complexity: O(h)
        */

        if(root == null) {
            return null;
        }

        TreeNode temp = dfs(root.left);
        root.left = dfs(root.right);
        root.right = temp;
        return root;
    }

}
