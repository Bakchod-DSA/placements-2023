/**
 * Author : Sradha Kedia
 * Page no.: 276,277, 278 of Epi Java
 * Problem no.: 15.12
 * Difficulty level : Medium
 */

package EPI.Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class Problem15_12_RangeLookupInBST {

//    public static List<Integer> rangeLookupInBst(BstNode<Integer> tree,
//                                                 Interval interval) {
//        List<Integer> result = new ArrayList<>();
//        searchNodes(tree, interval.left, interval.right, result);
//        return result;
//    }
//
//    private static void searchNodes(BstNode<Integer> tree, int start, int end, List<Integer> result) {
//    /*  Approach: Optimised Brute Force using BST property.
//        Time Complexity: O(h + m), since first two case go O(h) time but adding m nodes in the list
//                         i.e. "else part" takes O(m) time, traversing the further nodes that may lie in the interval.
//        Space Complexity: O(h)
//        general Brute Force is to perform any one of the tree traversal
//        and then record all the values that lie in the interval.
//    */
//
//        if(tree == null) {
//            return;
//        }
//
//        if(tree.data < start) {
//            searchNodes(tree.right, start, end, result);
//        } else if(tree.data > end) {
//            searchNodes(tree.left, start, end, result);
//        } else {
//            // i.e. if(tree.data >= start && tree.data <= end)
//            // do inorder to store nodes in sorted order.
//            searchNodes(tree.left, start, end, result);
//            result.add(tree.data);
//            searchNodes(tree.right, start, end, result);
//        }
//    }
}
