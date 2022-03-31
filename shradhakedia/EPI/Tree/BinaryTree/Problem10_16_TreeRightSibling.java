/**
 * Author : Sradha Kedia
 * Page no.: 171, 172 of Epi Java
 * Problem no.: 10.16
 * Difficulty level : Medium
 */

package EPI.Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Problem10_16_TreeRightSibling {

//    public static void constructRightSibling(BinaryTreeNode<Integer> tree) {
//        // dfs(tree);
//        // bfs(tree);
//        optimisedApproach3(tree);
//    }
//
//    private static void bfs(BinaryTreeNode<Integer> tree) {
//    /*  Approach: bfs
//        Time Complexity: O(n)
//        Space Complexity: O(h)
//    */
//
//        if(tree == null) {
//            return;
//        }
//
//        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
//        queue.add(tree);
//
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for(int i = 0; i < size; i++) {
//                BinaryTreeNode<Integer> node = queue.poll();
//                if(!queue.isEmpty() && i < size - 1) {
//                    node.next = queue.peek();
//                }
//                if(node.left != null) {
//                    queue.add(node.left);
//                }
//                if(node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//        }
//    }
//
//    private static void dfs(BinaryTreeNode<Integer> tree) {
//    /*  Works only for perfect tree.
//        Approach: dfs (preorder)
//        Time Complexity: O(n)
//        Space Complexity: O(h)
//    */
//
//        Stack<BinaryTreeNode<Integer>> stack = new Stack<>();
//        BinaryTreeNode<Integer> curr = tree;
//        BinaryTreeNode<Integer> parent = null;
//
//        while(!stack.isEmpty() || curr != null) {
//
//            while(curr != null) {
//                if(parent != null && parent.left == curr) {
//                    curr.next = parent.right;
//                } else if(parent != null && parent.right == curr && parent.next != null) {
//                    curr.next = parent.next.left;
//                }
//
//                stack.push(curr);
//                parent = curr;
//                curr = curr.left;
//
//            }
//
//            parent = stack.pop();
//            curr = parent.right;
//        }
//    }
//
//    private static void optimisedApproach3(BinaryTreeNode<Integer> tree) {
//    /*  Works only for perfect tree.
//        Approach: Optimised for perfect tree
//        Time Complexity: O(n)
//        Space Complexity: O(1)
//     */
//
//        BinaryTreeNode<Integer> leftMostNode = tree;
//        while(leftMostNode != null && leftMostNode.left != null) {
//            populateLowerLevelNextField(leftMostNode);
//            leftMostNode = leftMostNode.left;
//        }
//    }
}
