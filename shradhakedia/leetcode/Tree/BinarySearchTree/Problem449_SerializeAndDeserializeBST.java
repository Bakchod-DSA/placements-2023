/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/serialize-and-deserialize-bst/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinarySearchTree;

public class Problem449_SerializeAndDeserializeBST {

    StringBuilder sb = new StringBuilder();
    int index = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        preorder(root);
        return sb.toString();
    }

    private void preorder(TreeNode root) {
        if(root == null) {
            return;
        }

        sb.append(root.val + ",");
        preorder(root.left);
        preorder(root.right);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] preorderList = (data == "")? new String[0] : data.split(",");
        return constructBST(preorderList, Integer.MAX_VALUE);
    }

    private TreeNode constructBST(String[] preorderList, int bound) {
        if(index == preorderList.length || Integer.parseInt(preorderList[index]) > bound) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(preorderList[index++]));
        node.left = constructBST(preorderList, node.val);
        node.right = constructBST(preorderList, bound);

        return node;
    }
}
