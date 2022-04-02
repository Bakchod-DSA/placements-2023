/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/increasing-order-search-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinarySearchTree;

public class Problem897_IncreasingOrderSearchTree {

    TreeNode node = new TreeNode();

    public TreeNode increasingBST(TreeNode root) {

        // return morrisTraversal(root);
        TreeNode ans = node;
        inorder(root);
        return ans.right;
    }

    private TreeNode morrisTraversal(TreeNode root) {
        /*  Approach: morris Traversal
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        TreeNode prev = new TreeNode();
        TreeNode curr = root;
        TreeNode ans = prev;

        while(curr != null) {
            if(curr.left != null) {
                TreeNode node = curr.left;

                while(node.right != null) {
                    node = node.right;
                }
                node.right = curr;

                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;

            } else {
                prev.right = curr;
                prev = curr;
                curr = curr.right;
            }
        }

        return ans.right;
    }


    private void inorder(TreeNode root) {
        /*  Approach: inorder Traversal
            Time Complexity: O(n)
            Space Complexity: O(h)
        */

        if(root == null) {
            return;
        }

        inorder(root.left);
        root.left = null;
        node.right = root;
        node = root;
        inorder(root.right);
    }
}
