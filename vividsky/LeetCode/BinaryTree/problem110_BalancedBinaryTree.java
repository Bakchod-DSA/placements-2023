package LeetCode.BinaryTree;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/balanced-binary-tree/
 * Difficulty level : Easy
 */
public class problem110_BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        int height = calculateHeight(root);
        return height != -1;
    }

    /**
     * Bottom Up Approach
     Time : O(N)
     Space: O(H) where H is height of tree
     Algo : Calculate whether right and left subtree is balanced or not
             if not -> return -1;
             if yes -> return its max height

     Note : There can be a top down approach
            calculate height of each nodes children and compare them
            This approach calculate height of a node n O(N) time in worst case hence lead to a N^2 time complexity
            to find height of each node
     */
    private int calculateHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = calculateHeight(root.left);
        int right = calculateHeight(root.right);
        if (left != -1 && right != -1 && Math.abs(left - right) <= 1) {
            return Math.max(left, right) + 1;
        } else {
            return -1;
        }
    }
}
