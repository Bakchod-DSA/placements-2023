/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/diameter-of-binary-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

public class Problem543_DiameterOfABinaryTree {

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // approachOne(root);
        // return diameter;

        dfs(root);
        return diameter;
    }

    private void approachOne(TreeNode root) {
        if(root == null) {
            return;
        }

        int lt = height(root.left);
        int rt = height(root.right);
        diameter = Math.max(diameter, lt + rt);
        approachOne(root.left);
        approachOne(root.right);

    }

    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int lt = height(root.left);
        int rt = height(root.right);
        return Math.max(lt, rt) + 1;
    }


    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int lt = dfs(root.left);
        int rt = dfs(root.right);
        diameter = Math.max(diameter, lt + rt);
        return Math.max(lt, rt) + 1;
    }

}
