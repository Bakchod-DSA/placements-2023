/**
 * Author : Sradha Kedia
 * Page no.: 260, 261 of Epi Java
 * Problem no.: 15.3
 * Difficulty level : Medium
 */

package EPI.Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem15_3_KLargestValuesInBst {

//    public static List<Integer> findKLargestInBst(BstNode<Integer> tree, int k) {
//    /*  Approach: reverse inorder
//        Time complexity: O(h + k)
//        Space Complexity: O(h)
//    */
//
//        List<Integer> kLargest = new ArrayList<>();
//        Stack<BstNode<Integer>> stack = new Stack<>();
//        BstNode<Integer> curr = tree;
//        while((curr != null || !stack.isEmpty()) && kLargest.size() < k) {
//            while(curr != null) {
//                stack.add(curr);
//                curr = curr.right;
//            }
//
//            curr = stack.pop();
//            kLargest.add(curr.data);
//            curr = curr.left;
//        }
//
//        return kLargest;
//    }

}
