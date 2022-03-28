/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/binary-tree-preorder-traversal/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem144_BTPreorderTraversal {

    List<Integer> preorder = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        // approachOne(root);
        // return preorder;

        return approachTwo(root);
    }

    private void approachOne(TreeNode root) {
        /*  Approach: dfs -> recursive approach
            Time Complexity: O(n)
            Space Complexity: O(h), height of the tree due to recursive stack
        */

        if(root == null) {
            return;
        }
        preorder.add(root.val);
        approachOne(root.left);
        approachOne(root.right);
    }

    private List<Integer> approachTwo(TreeNode root) {
        /*  Approach: dfs + stack -> iterative approach
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        List<Integer> preorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                preorder.add(curr.val);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            curr = temp.right;
        }

        return preorder;
    }

}
