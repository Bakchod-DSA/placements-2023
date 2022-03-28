/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/binary-tree-level-order-traversal/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem102_LevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode root) {
        /*  Approach: bfs + iteration
            Time Complexity: O(n)
            Space Copmplexity: O(n)
        */

        if(root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> levelorder = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            List<Integer> singleLevel = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                singleLevel.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            levelorder.add(singleLevel);
        }

        return levelorder;
    }

}
