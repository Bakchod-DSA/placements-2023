/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem107_BTBottomUpLevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode root) {
        /*  Approach: bfs
            Time Complexity: O(n)
            Space Complexity: O(n)
        */

        if(root == null) {
            return new ArrayList<>();
        }

        LinkedList<List<Integer>> bottomUpLevels = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        // Stack<List<Integer>> stack = new Stack<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            // stack.push(level);
            bottomUpLevels.addFirst(level);
        }

        // while(!stack.isEmpty()) {
        //     bottomUpLevels.add(stack.pop());
        // }
        return bottomUpLevels;
    }
}
