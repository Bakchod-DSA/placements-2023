/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/maximum-width-of-binary-tree/
 * Difficulty level: Medium
 */
package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem662_MaximumWidthOfBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        return bfs(root);
    }

    private int bfs(TreeNode root) {
        Deque<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(root, 1));
        int maxWidth = 1;

        while(!queue.isEmpty()) {
            int size = queue.size();
            int width = 0;
            int start = 0, end = 0;
            for(int i = 0; i < size; i++) {
                Pair pair = queue.removeFirst();
                TreeNode node = pair.node;
                int id = pair.id;

                if(node.left != null) queue.addLast(new Pair(node.left, id * 2));
                if(node.right != null) queue.addLast(new Pair(node.right, id * 2 + 1));

                if(i == 0) start = id;
                if(size != 1 && i == size - 1) end = id;
                if(start != 0 && end != 0) width = end - start + 1;
            }
            maxWidth = Math.max(maxWidth, width);
        }

        return maxWidth;
    }

    class Pair {
        TreeNode node;
        int id;
        Pair(TreeNode node, int id) {
            this.node = node;
            this.id = id;
        }
    }
}
