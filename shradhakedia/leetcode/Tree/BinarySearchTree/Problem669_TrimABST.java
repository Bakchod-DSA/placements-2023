/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/trim-a-binary-search-tree/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinarySearchTree;

public class Problem669_TrimABST {

    TreeNode parent;
    TreeNode Root;

    public TreeNode trimBST(TreeNode root, int low, int high) {

        parent = null;
        Root = root;
        // return approachOne(root, low, high);
        return approachTwo(root, low, high);
    }

    private TreeNode approachOne(TreeNode root, int low, int high) {
        /*  Approach: Brute Force, Preorder traversal -> first deal with children to delete the nodes
                      and then go to parent to further deal with it.
            Time Complexity: O(n * h)
            Space Complexity: O(h * h)
            worst case is n^2.
        */

        if(root == null) {
            return null;
        }

        approachOne(root.left, low, high);
        approachOne(root.right, low, high);

        if(root.val < low || root.val > high) {
            Root = delete(Root, root.val);
        }

        return Root;
    }


    private TreeNode delete(TreeNode root, int key) {
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

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    private TreeNode approachTwo(TreeNode root, int low, int high) {
        /*  Approach: Recursion
            Time Complexity: O(n)
            Space Complexity: O(n)
            worst case is n^2.
        */

        // base cases
        if(root == null) {
            return null;
        }
        if(root.val < low) {
            return approachTwo(root.right, low, high);
        }
        if(root.val > high) {
            return approachTwo(root.left, low, high);
        }

        root.left = approachTwo(root.left, low, high);
        root.right = approachTwo(root.right, low, high);

        return root;
    }
}
