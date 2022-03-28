/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem106_ConstructBTFromPostorderInorder {

    Map<Integer, Integer> hashTable;
    int index;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        hashTable = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            hashTable.put(inorder[i], i);
        }

        index = postorder.length - 1;
        return approachOne(postorder, 0, postorder.length - 1);
    }

    private TreeNode approachOne(int[] postorder, int left, int right) {
        /*  Approach: divide and conquer + hashing
            Time Complexity: O(n)
            Space Complexity: O(n + h), n = hashTable.size(), h = height of the tree, build by the recursion stack.
        */

        // if there are no elements to construct the tree
        if(left > right) {
            return null;
        }

        // select the postorder_index element as the root from the back of the postorder array and decrement it.
        TreeNode root = new TreeNode(postorder[index--]);

        // build right and left subtree because we are taking root from the back of the array right subtree is formed before
        // left subtree.
        // excluding hashTable(root.val) element because it's the root
        root.right = approachOne(postorder, hashTable.get(root.val) + 1, right);
        root.left = approachOne(postorder, left, hashTable.get(root.val) - 1);
        return root;
    }
}
