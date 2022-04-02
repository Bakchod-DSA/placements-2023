/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/range-sum-of-bst/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinarySearchTree;

public class Problem938_RangeSumOfBST {

    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        sumTree(root, low, high);
        return sum;
    }

    private void sumTree(TreeNode root, int low, int high) {
        /*  Approach: brute force
            Time Complexity: O(n)
            Space Complexity: O(h)
        */

        if(root == null) {
            return;
        }

        if(root.val >= low && root.val <= high) {
            sum += root.val;
            sumTree(root.left, low, high);
            sumTree(root.right, low, high);
        } else if(root.val < low) {
            sumTree(root.right, low, high);
        } else {
            sumTree(root.left, low, high);
        }
    }
}
