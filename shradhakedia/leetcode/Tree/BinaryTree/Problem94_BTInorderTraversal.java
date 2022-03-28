/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/binary-tree-inorder-traversal/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem94_BTInorderTraversal {

    List<Integer> inorder = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {

        // approachOne(root);
        approachTwo(root);
        // approachThree(root);

        return inorder;
    }

    private void approachOne(TreeNode root) {
        /*  Approach: dfs -> recursive approach
            Time Complexity: O(n)
            Space Complexity: O(h), height of the tree due to recursive stack
        */

        if(root == null) {
            return;
        }
        approachOne(root.left);
        inorder.add(root.val);
        approachOne(root.right);
    }

    private void approachTwo(TreeNode root) {
        /*  Approach: dfs + stack -> iterative approach
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            inorder.add(temp.val);
            curr = temp.right;
        }
    }

    private void approachThree(TreeNode root) {
        /*  Approach: morris Traversal
            Time Complexity: O(n)
            Space Complexity: O(1)
        */

        TreeNode curr = root;
        while(curr != null) {
            if(curr.left == null) {
                inorder.add(curr.val);
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
    }
}
