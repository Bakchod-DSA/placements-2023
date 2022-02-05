/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/binary-tree-paths/
 * Difficulty level: Medium
 */


package leetcode.Backtracking;

import java.util.*;


public class Problem257_BinaryTreePaths {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {

        List<String> list = new ArrayList<>();
        StringBuilder ans = new StringBuilder();

        if(root != null) {
            ans.append(root.val);
            approachOne(list, ans, root);
        }

        return list;

    }

    private void approachOne(List<String> list, StringBuilder ans, TreeNode root) {

        if(root.left == null && root.right == null) {
            list.add(ans.toString());
            return;
        }

        int len = ans.length();

        if(root.left != null) {
            ans.append("->" + root.left.val);
            approachOne(list, ans, root.left);
            ans.setLength(len);

        }

        if(root.right != null) {
            ans.append("->" + root.right.val);
            approachOne(list, ans, root.right);
            ans.setLength(len);

        }


    }

}
