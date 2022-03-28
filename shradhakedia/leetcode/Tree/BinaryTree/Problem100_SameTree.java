/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/same-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

public class Problem100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return checkSameTree(p, q);
    }

    private boolean checkSameTree(TreeNode p, TreeNode q) {
        /*  Approach: dfs -> recursive
            Time Complexity: O(n)
            Space Complexity: O(h), height of the tree
        */

        if(p == null && q == null) {
            return true;
        } else if(p != null && q != null) {
            return p.val == q.val && checkSameTree(p.left, q.left) && checkSameTree(p.right, q.right);
        }

        return false;
    }

}
