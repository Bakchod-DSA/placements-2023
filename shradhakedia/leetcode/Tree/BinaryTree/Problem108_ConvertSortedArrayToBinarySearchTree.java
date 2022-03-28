/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem108_ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return approachOne(nums);
    }

    private TreeNode approachOne(int[] nums) {
        /*  Approach: Divide And Conquer
            Time Complexity: O(n)
            Space Complexity: O(log n), height of the tree
        */

        if(nums.length == 0) {
            return null;
        }
        int index = nums.length/2;
        TreeNode root = new TreeNode();
        root.val = nums[index];
        root.left = approachOne(Arrays.copyOfRange(nums, 0, index));
        root.right = approachOne(Arrays.copyOfRange(nums, index + 1, nums.length));

        return root;
    }
}
