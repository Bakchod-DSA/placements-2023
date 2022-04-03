/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinarySearchTree;

public class Problem653_TwoSumIVInputIsABST {

    public boolean findTarget(TreeNode root, int k) {
        /* Approach 1. The idea is to use binary search method. For each node, we check if k - node.val exists in this
                     BST.
                     Time Complexity: O(nh), Space Complexity: O(h). h is the height of the tree, which is logn at
                     best case, and n at worst case.
           Approach 2. This method also works for those who are not BSTs. The idea is to use a hashtable to save the                            values of the nodes in the BST. Each time when we insert the value of a new node into the
                     hashtable, we check if the hashtable contains k - node.val.
                     Time Complexity: O(n), Space Complexity: O(n).
           Approach 3. The idea is to use a sorted array to save the values of the nodes in the BST by using an inorder
                     traversal. Then, we use two pointers which begins from the start and end of the array to find if
                     there is a sum k.
                     Time Complexity: O(n), Space Complexity: O(n).
        */

        return approachOne(root, root, k);
    }

    private boolean approachOne(TreeNode root, TreeNode node, int k) {
        /*  Approach: Brute Force
            Time Complexity: O(n * logn)
            Space Complexity: O(h)
        */

        if(root == null) {
            return false;
        }

        // we find the left part of sum pair for each node and as soon as we get one pair valid we return true.
        int target = k - root.val;
        if(target != root.val && search(node, target)) {
            // since its a BST with unique value. Therefore, when root.val + target = k then this implies we are
            // searching for the same no. as root which we can never get in the BST. Hence, we dont need to
            // search in this case.
            return true;
        }
        return approachOne(root.left, node, k) || approachOne(root.right, node, k);


    }

    private boolean search(TreeNode root, int target) {
        /*  Approach: Brute Force
            Time Complexity: O(logn)
            Space Complexity: O(h)
        */

        if(root == null) {
            return false;
        }

        if(target == root.val) {
            return true;
        } else if(target < root.val) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }
}
