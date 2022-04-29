/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/delete-node-in-a-bst/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinarySearchTree;

import java.util.Stack;

public class Problem450_DeleteNodeInBST {

    TreeNode parent;

    public TreeNode deleteNode(TreeNode root, int key) {

        parent = null;

        // return approachOne(root, key);
        return approachTwo(root, key);
    }

    private TreeNode approachOne(TreeNode root, int key) {
        /*  Approach: preorder to search the node to be deleted and update its parent, preorder continues after the node is deleted
            Time complexity: O(n)
            Space Complexity: O(h), stack size.
        */

        // in case we need to delete the root
        TreeNode Root = new TreeNode(Integer.MAX_VALUE);
        Root.left = root;

        TreeNode prev = Root;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();

        while(curr != null || !stack.isEmpty()) {

            while(curr != null) {
                if(curr.val == key) {
                    if(isLeaf(curr)) {
                        if(prev.right == curr) {
                            prev.right = null;
                        } else {
                            prev.left = null;
                        }
                    } else if(curr.left == null && curr.right != null) {
                        if(prev.right == curr) {
                            prev.right = curr.right;
                        } else {
                            prev.left = curr.right;
                        }
                    } else if(curr.left != null && curr.right == null) {
                        if(prev.right == curr) {
                            prev.right = curr.left;
                        } else {
                            prev.left = curr.left;
                        }
                    } else {
                        TreeNode temp = curr.right;
                        while(temp.left != null) {
                            temp = temp.left;
                        }
                        temp.left = curr.left;
                        if(prev.right == curr) {
                            prev.right = curr.right;
                        } else {
                            prev.left = curr.right;
                        }
                    }
                }
                stack.push(curr);
                prev = curr;
                curr = curr.left;
            }

            prev = stack.pop();
            curr = prev.right;
        }

        return Root.left;
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private TreeNode approachTwo(TreeNode root, int key) {
        /*  Approach: search the node to be deleted and update its parent.
            Time complexity: O(h)
            Space Complexity: O(h) due to search function recursive stack
        */

        TreeNode Root = new TreeNode(Integer.MAX_VALUE);
        Root.left = root;

        TreeNode toDelete = search(Root, key);
        if(toDelete != null) {

            if(isLeaf(toDelete)) {
                if(parent.right == toDelete) {
                    parent.right = null;
                } else {
                    parent.left = null;
                }
            } else if(toDelete.left == null && toDelete.right != null) {
                if(parent.right == toDelete) {
                    parent.right = toDelete.right;
                } else {
                    parent.left = toDelete.right;
                }
            } else if(toDelete.left != null && toDelete.right == null) {
                if(parent.right == toDelete) {
                    parent.right = toDelete.left;
                } else {
                    parent.left = toDelete.left;
                }
            } else {
                TreeNode temp = toDelete.right;
                while(temp.left != null) {
                    temp = temp.left;
                }
                temp.left = toDelete.left;
                if(parent.right == toDelete) {
                    parent.right = toDelete.right;
                } else {
                    parent.left = toDelete.right;
                }
            }
        }

        return Root.left;
    }

    private TreeNode search(TreeNode node, int key) {
        /*  Approach: Binary search
            Time complexity: O(h)
            Space Complexity: O(h)
        */

        if(node == null) {
            return null;
        }

        if(node.val == key) {
            return node;
        } else if(node.val < key) {
            parent = node;
            return search(node.right, key);
        } else {
            parent = node;
            return search(node.left, key);
        }
    }

}
