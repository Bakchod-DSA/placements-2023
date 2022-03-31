/**
 * Author : Sradha Kedia
 * Page no.: 169, 170, 171 of Epi Java
 * Problem no.: 10.15
 * Difficulty level : Medium
 */

package EPI.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Problem10_15_ExteriorOfABT {

//    public static List<BinaryTreeNode<Integer>> exteriorBinaryTree(BinaryTreeNode<Integer> tree) {
//    /*  Approach: Intuitive
//        Time Complexity: O(n)
//        Space Complexity: O(h)
//        Explanation: The idea is to firstly record the leftmost nodes then the leaves from left to right order and then
//                     the rightmost nodes. we will divide the tree in two parts left and right subtree add the root to answer.
//                     now, we traverse left tree to firstly get all the leftmost nodes and then the leaves in left subtree.
//                     //ly we go to right subtree and fetch all the leaves of the subtree first then the rightmost nodes.
//                     the idea is implemented using recursion, we take a bool flag is boundary, in left subtree we go to
//                     leftmost nodes , with isBoundary set as true. if we have a node we add it. if not then we go to right
//                     node and set boundary to false if left was not null i.e. isBoundary = isBoundary && subtreeRoot.left == null.
//                     like this we traverse left tree. we do opposite in right subtree, firstly we go to left tree of
//                     right subtree with isBoundary = isBoundary && subtreeRoot.right == null. then we go to right subtree
//                     with isBoundary as it was before and then we check in the end if curr subtreeRoot is leaf or isBoundary
//                     we add it to result if one case is true.
//    */
//
//        List<BinaryTreeNode<Integer>> exterior =  new LinkedList<>();
//        if(tree != null) {
//            exterior.add(tree);
//            exterior.addAll(leftBoundaryAndLeaves(tree.left, true));
//            exterior.addAll(rightBoundaryAndLeaves(tree.right, true));
//        }
//
//        return exterior;
//    }
//
//    // computes the nodes from the root to the leftmost leaf followed by
//    // all the leaves in subtreeRoot.
//    private static List<BinaryTreeNode<Integer>> leftBoundaryAndLeaves(BinaryTreeNode<Integer> subtreeRoot, boolean isBoundary) {
//
//        List<BinaryTreeNode<Integer>> result = new LinkedList<>();
//        if(subtreeRoot != null) {
//            if (isBoundary || isLeaf(subtreeRoot)) {
//                result.add(subtreeRoot);
//            }
//            result.addAll(leftBoundaryAndLeaves(subtreeRoot.left, isBoundary));
//            result.addAll(leftBoundaryAndLeaves(subtreeRoot.right, isBoundary && subtreeRoot.left == null));
//        }
//
//        return result;
//    }
//
//    // computes the leaves in left to right order followed by the rightmost leaf to the root path in subtreeRoot.
//    private static List<BinaryTreeNode<Integer>> rightBoundaryAndLeaves(BinaryTreeNode<Integer> subtreeRoot, boolean isBoundary) {
//        List<BinaryTreeNode<Integer>> result = new LinkedList<>();
//        if(subtreeRoot != null) {
//            result.addAll(rightBoundaryAndLeaves(subtreeRoot.left, isBoundary && subtreeRoot.right == null));
//            result.addAll(rightBoundaryAndLeaves(subtreeRoot.right, isBoundary));
//
//            if(isBoundary || isLeaf(subtreeRoot)) {
//                result.add(subtreeRoot);
//            }
//        }
//        return result;
//    }
//
//    private static boolean isLeaf(BinaryTreeNode<Integer> node) {
//        return node.left == null && node.right == null;
//    }
//
//    private static List<BinaryTreeNode<Integer>> rough(BinaryTreeNode<Integer> tree) {
//        List<BinaryTreeNode<Integer>> exterior = new LinkedList<>();
//        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
//        int left = 0;
//        BinaryTreeNode<Integer> curr = tree;
//
//        while (curr != null || !stack.isEmpty()) {
//
//            while(left == 0 && curr != null && (curr.right != null || curr.left != null)) {
//                exterior.add(curr);
//                stack.push(curr);
//                curr = curr.left;
//            }
//
//            if(curr != null && curr.right == null && curr.left == null) {
//                left = 1;
//                exterior.add(curr);
//                curr = null;
//            }
//
//            while(curr != null  && (curr.right != null || curr.left != null)) {
//                stack.push(curr);
//                curr = curr.left;
//            }
//
//            if(curr == null  && !stack.isEmpty()) {
//                curr = stack.pop().right;
//            }
//        }
//
//        LinkedList<BinaryTreeNode<Integer>> rightExterior = new LinkedList<>();
//        curr = (tree != null)? tree.right : null;
//
//        while(curr != null) {
//            rightExterior.addFirst(curr);
//            curr = (curr.right == null)? curr.left : curr.right;
//        }
//
//        if(!rightExterior.isEmpty()) rightExterior.removeFirst();
//        exterior.addAll(rightExterior);
//
//        return exterior;
//    }
}
