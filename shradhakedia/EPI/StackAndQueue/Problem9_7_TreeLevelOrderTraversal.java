/**
 * Author : Sradha Kedia
 * Page no.: 143,144 of Epi Java
 * Problem no.: 9.7
 * Difficulty level : Medium
 */

package EPI.StackAndQueue;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Problem9_7_TreeLevelOrderTraversal {

//    public static List<List<Integer>> binaryTreeDepthOrder(BinaryTreeNode<Integer> tree) {
//        if(tree == null) return new ArrayList<>();
//
//        List<List<Integer>> levelOrder = new ArrayList<>();
//        Deque<BinaryTreeNode<Integer>> queue = new LinkedList<>();
//        queue.addLast(tree);
//
//        while (!queue.isEmpty()) {
//            int size = queue.size();
//            List<Integer> level = new ArrayList<>();
//            for(int i = 0; i < size; i++) {
//                BinaryTreeNode<Integer> node = queue.removeFirst();
//                level.add(node.data);
//                if(node.left != null) {
//                    queue.addLast(node.left);
//                }
//                if(node.right != null) {
//                    queue.addLast(node.right);
//                }
//            }
//            levelOrder.add(level);
//        }
//        return levelOrder;
//    }

}
