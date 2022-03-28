/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem105_ConstructBTFromPreorderInorder {

    Map<Integer, Integer> hashTable;
    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        hashTable = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            hashTable.put(inorder[i], i);
        }
        return approachOne(preorder, 0, preorder.length - 1);
    }

    private TreeNode approachOne(int[] preorder, int left, int right) {
        /*  Approach: divide and conquer + hashing
            Time Complexity: O(n)
            Space Complexity: O(n + h), n = hashTable.size(), h = height of the tree, build by the recursion stack.
        */

        // if there are no elements to construct the tree
        if(left > right) {
            return null;
        }

        // select the preorder_index element as the root and increment it
        TreeNode root = new TreeNode(preorder[index++]);

        // build left and right subtree
        // excluding hashTable(root.val) element because it's the root
        root.left = approachOne(preorder, left, hashTable.get(root.val) - 1);
        root.right = approachOne(preorder, hashTable.get(root.val) + 1, right);

        return root;
    }
}
