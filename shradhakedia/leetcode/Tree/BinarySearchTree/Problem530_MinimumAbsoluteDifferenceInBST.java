/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-absolute-difference-in-bst/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinarySearchTree;

import java.util.*;

public class Problem530_MinimumAbsoluteDifferenceInBST {
    public int minimum = Integer.MAX_VALUE;
    TreeNode prev = null;

    public int getMinimumDifference(TreeNode root) {

        // return iterInorder(root);
        return recurInorder(root);
    }

    private int recurInorder(TreeNode root) {
        /*  Approach: recursive Inorder
            Time Complexity: O(n)
            Space Complexity: O(h)
        */

        if(root == null) {
            return minimum;
        }

        recurInorder(root.left);

        if(prev != null) {
            minimum = Math.min(minimum, Math.abs(root.val - prev.val));
        }


        prev = root;
        recurInorder(root.right);

        return minimum;

    }

    private int iterInorder(TreeNode root) {
        /*  Approach: iterative Inorder
            Time Complexity: O(2n)
            Space Complexity: O(n + h)
        */

        int minimum = Integer.MAX_VALUE;
        List<Integer> inorder = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;

        while(curr != null || !stack.isEmpty()) {
            while(curr != null){
                stack.push(curr);
                curr = curr.left;
            }

            curr = stack.pop();
            inorder.add(curr.val);
            curr = curr.right;
        }

        for(int i = 0; i < inorder.size() - 1; i++) {
            minimum = Math.min(minimum, Math.abs(inorder.get(i) - inorder.get(i + 1)));
        }

        return minimum;
    }
}
