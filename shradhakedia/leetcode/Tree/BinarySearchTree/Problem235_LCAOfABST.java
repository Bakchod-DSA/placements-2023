/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinarySearchTree;

public class Problem235_LCAOfABST {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(root, p, q);
    }

    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val < root.val && q.val < root.val) {
            return lca(root.left, p, q);
        } else if(p.val > root.val && q.val > root.val) {
            return lca(root.right, p, q);
        } else {
            return root;
        }
    }
}
