package LeetCode.BinaryTree;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * Difficulty level : Easy
 */
public class problem_235_LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val <= root.val && root.val <= q.val || q.val <= root.val && root.val <= p.val) {
            return root;
        } else if (p.val <= root.val) {
            return dfs(root.left, p, q);
        } else {
            return dfs(root.right, p, q);
        }
    }
}
