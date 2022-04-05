/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/balance-a-binary-search-tree/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinarySearchTree;

import java.util.*;

public class Problem1382_BalanceABST {

    public TreeNode balanceBST(TreeNode root) {

        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);
        return constructBST(sorted, 0, sorted.size() - 1);
    }

    private void inorder(TreeNode root, List<Integer> sorted) {
        /*  Approach: inorder
            Time Complexity: O(n)
            Space Complexity: O(h)
        */

        if(root == null) {
            return;
        }

        inorder(root.left, sorted);
        sorted.add(root.val);
        inorder(root.right, sorted);
    }

    private TreeNode constructBST(List<Integer> sorted, int low, int high) {
        /*  Approach: Divide and Conquer
            Time Complexity: O(n)
            Space Complexity: O(log n)
        */

        if(low > high) {
            return null;
        }

        int index = (low + high) >> 1;

        TreeNode root = new TreeNode(sorted.get(index));
        root.left = constructBST(sorted, low, index - 1);
        root.right = constructBST(sorted, index + 1, high);
        return root;
    }
}
