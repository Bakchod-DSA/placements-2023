/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinarySearchTree;

public class Problem1008_ConstructBSTFromPreorder {

    int index = 0;

    public TreeNode bstFromPreorder(int[] preorder) {

        // return constructBst(preorder, Integer.MAX_VALUE);
        return bruteForce(preorder, 0, preorder.length);
    }

    private TreeNode constructBst(int[] preorder, int bound) {
        /*  Approach: Optimised
            Time Complexity: O(n)
            Space Complexity: O(h)
        */

        if(index == preorder.length || preorder[index] > bound) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[index++]);
        node.left = constructBst(preorder, node.val);
        node.right = constructBst(preorder, bound);

        return node;
    }

    private TreeNode bruteForce(int[] preorder, int start, int end) {
        /*  Approach: brute Force
            Time Complexity: O(n ^ 2) worst, O(n logn) average, O(n) best.
            Space Complexity: O(h)
        */

        if(start >= end) {
            return null;
        }

        int transitionPoint = start + 1;
        while(transitionPoint < end && preorder[transitionPoint] < preorder[start]) {
            transitionPoint++;
        }

        return new TreeNode(preorder[start], bruteForce(preorder, start + 1, transitionPoint), bruteForce(preorder, transitionPoint, end));
    }
}
