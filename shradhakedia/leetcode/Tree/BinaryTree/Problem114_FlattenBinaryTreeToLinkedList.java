/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinaryTree;

public class Problem114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        postorder(root);
    }

    private TreeNode postorder(TreeNode root) {
        /*  Approach: Postorder
            Time Complexity: O(2n)
            Space Complexity: O(1)
        */

        if(root == null) {
            return null;
        }

        TreeNode lt = postorder(root.left);
        TreeNode rt = postorder(root.right);

        // if left is null, then we need to attach right flattened tree to curr node's right
        if(root.left == null) {
            root.right = rt;
            return root;
        }

        // else, we set curr.left to null, set its right to left flattened then traverse the left flattened
        // till end to set its right to right flattened list.
        root.left = null;
        root.right = lt;
        while(lt != null && lt.right != null) {
            lt = lt.right;
        }
        if(lt != null) {
            lt.right = rt;
        }

        return root;
    }
}
