/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/search-in-a-binary-search-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinarySearchTree;

public class Problem700_SearchInBST {

    public TreeNode searchBST(TreeNode root, int val) {
        return search(root, val);
    }

    private TreeNode search(TreeNode root, int val) {
        /*  Approach: Brute force
            Time Complexity: O(log n), worst case O(n) skewed tree.
            Space Complexity: O(log n), worst case O(n) skewed tree.
        */

        if(root == null) {
            return null;
        }

        if(root.val == val) {
            return root;
        }

        if(root.val < val) {
            return search(root.right, val);
        }

        return search(root.left, val);

    }
}
