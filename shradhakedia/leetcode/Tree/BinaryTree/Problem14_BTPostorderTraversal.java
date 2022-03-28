/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/binary-tree-postorder-traversal/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem14_BTPostorderTraversal {

    List<Integer> postorder = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {

        // return approachOne(root);

        approachTwo(root);
        return postorder;
    }

    private List<Integer> approachOne(TreeNode root) {
        /*  Approach: dfs + stack -> iterative approach
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        List<Integer> postorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            while(curr != null && (curr.left != null || curr.right != null)) {
                stack.push(curr);
                curr = curr.left;
            }

            if(curr != null) {
                // left and right node
                postorder.add(curr.val);
            }

            while(!stack.isEmpty() && curr == stack.peek().right) {
                // after adding left, right. we add root now
                curr = stack.pop();
                postorder.add(curr.val);
            }

            if(stack.isEmpty()) {
                curr = null;
            } else {
                // to add the right child we replace curr by right child
                curr = stack.peek().right;
            }

        }

        return postorder;
    }

    private void approachTwo(TreeNode root) {
        /*  Approach: dfs -> recursive approach
            Time Complexity: O(n)
            Space Complexity: O(h), height of the tree due to recursive stack
        */

        if(root != null) {
            approachTwo(root.left);
            approachTwo(root.right);
            postorder.add(root.val);
        }
    }

}
