/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinarySearchTree;

import java.util.*;

public class Problem230_KthSmallestElementInBST {

    public int kthSmallest(TreeNode root, int k) {

        // return approachOne(root, k);
        List<Integer> inorder = approachTwo(root, new ArrayList<Integer>());
        return inorder.get(k - 1);
    }

    private int approachOne(TreeNode root, int k) {
        /*  Approach: dfs + iterative
            Time Complexity: O(H + k)
            Space Complexity: O(H), where H is a tree height.
        */

        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        stack.add(root);

        while(!stack.isEmpty() || curr != null) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode temp = stack.pop();
            k--;
            if(k == 0) {
                return temp.val;
            }
            curr = temp.right;
        }

        return -1;
    }

    private List<Integer> approachTwo(TreeNode root, List<Integer> arr) {
        /*  Approach: dfs + recursive
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        if(root == null) {
            return null;
        }

        approachTwo(root.left, arr);
        arr.add(root.val);
        approachTwo(root.right, arr);
        return arr;
    }

}
