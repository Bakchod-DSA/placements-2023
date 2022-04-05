/**
 * Author : Sradha Kedia
 * Page no.: 256, 257, 258 of Epi Java
 * Problem no.: 15.1
 * Difficulty level : Medium
 */

package EPI.Tree.BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;


public class Problem15_1_IsTreeABST {

//    public static boolean isBinaryTreeBST(BinaryTreeNode<Integer> tree) {
//        // return approachOne(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
//        return approachTwo(tree);
//        // we can also find inorder of the tree and check if its sorted if its not then nkt a bst.
//    }
//
//    private static boolean approachOne(BinaryTreeNode<Integer> root, int low, int high) {
//    /* Approach: preorder, using recursion
//       Time Complexity: O(n)
//       Space Complexity: O(h)
//    */
//
//        if(root == null) {
//            return true;
//        }
//
//        if(root.data >= low && root.data <= high) {
//            return approachOne(root.left, low, root.data) && approachOne(root.right, root.data, high);
//        }
//        return false;
//    }
//
//    private static boolean approachTwo(BinaryTreeNode<Integer> root) {
//    /* Approach: bfs
//       Time Complexity: O(n)
//       Space Complexity: O(h)
//       Explanation: why bfs? first approach explores the left child first, therefore, even if the BST property does not
//                    hold at a node which is close to the root(e.g., the key stored at the right child is less than the
//                    key stored at the root), their time complexity is still O(n). so, we can apply bfs here and check the
//                    violation of bst property at each level itself. if valid go deep(i.e. to the next level),
//                    else return false.
//    */
//
//        if(root == null) {
//            return true;
//        }
//
//        Queue<Pair> queue = new LinkedList<>();
//        queue.add(new Pair(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
//
//        while(!queue.isEmpty()) {
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Pair pair = queue.poll();
//                BinaryTreeNode<Integer> node = pair.node;
//
//                if(node.left != null) {
//                    if(node.left.data >= pair.low && node.left.data <= node.data) {
//                        queue.add(new Pair(node.left, pair.low, node.data));
//                    } else {
//                        return false;
//                    }
//                }
//
//                if(node.right != null) {
//                    if(node.right.data >= node.data && node.right.data <= pair.high) {
//                        queue.add(new Pair(node.right, node.data, pair.high));
//                    } else {
//                        return false;
//                    }
//                }
//            }
//        }
//
//        return true;
//    }
//
//    public static class Pair {
//        BinaryTreeNode<Integer> node;
//        int low;
//        int high;
//
//        Pair(BinaryTreeNode<Integer> node, int low, int high) {
//            this.node = node;
//            this.low = low;
//            this.high = high;
//        }
//    }

}
