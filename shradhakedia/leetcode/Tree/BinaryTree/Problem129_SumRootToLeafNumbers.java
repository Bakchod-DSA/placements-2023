/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/sum-root-to-leaf-numbers/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinaryTree;

public class Problem129_SumRootToLeafNumbers {

    int totalSum = 0;

    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return totalSum;
    }

    private void dfs(TreeNode root, int sum) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null) {
            totalSum += sum * 10 + root.val;
            return;
        }

        dfs(root.left, sum * 10 + root.val);
        dfs(root.right, sum * 10 + root.val);
    }

}
