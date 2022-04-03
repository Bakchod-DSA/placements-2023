/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/binary-search-tree-iterator/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinarySearchTree;

import java.util.Stack;

public class Problem173_BSTIterator {

    static class BSTIterator {

        private TreeNode node;
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            node = root;
            stack = new Stack<>();
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {

            TreeNode temp = stack.pop();
            node = temp.right;

            while(node != null) {
                stack.push(node);
                node = node.left;
            }

            return temp.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }

    /*
    public BSTIterator(TreeNode root) {
        node = root;
        stack = new Stack<>();

    }

    public int next() {
        int val = 0;
        if(node != null || !stack.isEmpty()) {
            while(node != null) {
                stack.push(node);
                node = node.left;
            }
            if(!stack.isEmpty()) {
                node = stack.pop();
                val = node.val;
                node = node.right;
            }
        }

        return val;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }
    */

    }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
