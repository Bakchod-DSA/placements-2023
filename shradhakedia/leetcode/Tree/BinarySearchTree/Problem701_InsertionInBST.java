/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/insert-into-a-binary-search-tree/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinarySearchTree;

public class Problem701_InsertionInBST {

    TreeNode parent;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        parent = null;
        return insert(root, val);
    }

    private TreeNode insert(TreeNode root, int val) {

        TreeNode toInsert = new TreeNode(val);
        TreeNode curr = root;

        if(curr == null) {
            return toInsert;
        }

        searchNextGreater(root, val);
        if(parent == null) {
            while(curr.right != null) {
                curr = curr.right;
            }
            curr.right = toInsert;
        } else {
            if(parent.left == null) {
                parent.left = toInsert;
            }
            else {
                TreeNode temp = parent.left;
                while(temp.right != null) {
                    temp = temp.right;
                }
                temp.right = toInsert;
            }
        }

        return root;
    }

    private void searchNextGreater(TreeNode root, int val) {
        if(root == null) {
            return;
        }

        if(root.val < val) {
            searchNextGreater(root.right, val);
        } else {
            parent = root;
            searchNextGreater(root.left, val);
        }
    }
}
