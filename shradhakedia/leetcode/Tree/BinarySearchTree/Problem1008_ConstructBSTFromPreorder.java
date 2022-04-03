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

        return constructBst(preorder, Integer.MAX_VALUE);
    }

    private TreeNode constructBst(int[] preorder, int prev) {
        if(index == preorder.length || preorder[index] > prev) {
            return null;
        }

        TreeNode node = new TreeNode(preorder[index++]);
        node.left = constructBst(preorder, node.val);
        node.right = constructBst(preorder, prev);

        return node;
    }
}
