/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/recover-binary-search-tree/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinarySearchTree;

import java.util.*;

// a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Problem99_RecoverBinaryTree {

    public void recoverTree(TreeNode root) {
        // inorder(root);
        morrisTraversal(root);
    }

    public void inorder(TreeNode root) {
        /*  Approach: dfs + iterative
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        boolean secondDip = false;

        while(!stack.isEmpty() || root != null) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            if(!secondDip && pre != null && pre.val > root.val) {
                first = pre;
                second = root;
                secondDip = true;
            }
            if(secondDip && pre != null && pre.val > root.val) {
                second = root;
            }
            pre = root;
            root = root.right;
        }

        // swap the nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    private void morrisTraversal(TreeNode root) {
        /*  Approach: morris Traversal
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        int min = Integer.MAX_VALUE;
        TreeNode curr = root;
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;

        while(curr != null) {

            if(pre != null && pre.val > curr.val) {
                if(first == null) {
                    first = pre;
                    second = curr;
                } else {
                    second = curr;
                }
            }

            if(curr.left == null) {
                pre = curr;
                curr = curr.right;
            } else {
                TreeNode curr1 = curr.left;
                while(curr1.right != null) {
                    curr1 = curr1.right;
                }
                curr1.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
        }

        // swap the nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}
