/**
 * Author : Sradha Kedia
 * Page no.: 259 of Epi Java
 * Problem no.: 15.2
 * Difficulty level : Medium
 */

package EPI.Tree.BinarySearchTree;

public class Problem15_2_SearchFirstGreaterValueInBst {

//    static BstNode<Integer> max;
//
//    public static BstNode<Integer> findFirstGreaterThanK(BstNode<Integer> tree,
//                                                         Integer k) {
//        // Brute force approach is using inorder traversal, TC: O(n).
//        // since this global variable is used for all test cases initialize it to null.
//        max = null;
//        findGreater(tree, k);
//        return max;
//    }
//
//    private static void findGreater(BstNode<Integer> tree,
//                                    Integer k) {
//    /* Approach: Binary Search (BST search property)
//       Time Complexity: O(h)
//       Space Complexity: O(h)
//    */
//
//        if(tree == null) {
//            return;
//        }
//
//        if(tree.data > k) {
//            max = tree;
//            findGreater(tree.left, k);
//        } else {
//            findGreater(tree.right, k);
//        }
//    }
}
