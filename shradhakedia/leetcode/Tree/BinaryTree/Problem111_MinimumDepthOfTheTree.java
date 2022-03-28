/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem111_MinimumDepthOfTheTree {

    public int minDepth(TreeNode root) {
        // return dfs(root);
        return bfs(root);
    }

    /** Solution 1: DFS
     * Key point:
     * if a node only has one child -> MUST return the depth of the side with child, i.e. MAX(left, right) + 1
     * if a node has two children on both side -> return min depth of two sides, i.e. MIN(left, right) + 1
     */
    private int dfs(TreeNode root) {
        /*  Approach: dfs + recursive
            Time Complexity: O(n)
            Space Complexity: O(h)
        */

        if(root == null) {
            return 0;
        }
        if(root.left == null) {
            return dfs(root.right) + 1;
        }
        if(root.right == null) {
            return dfs(root.left) + 1;
        }
        return Math.min(dfs(root.left), dfs(root.right)) + 1;
    }

    /** Solution2: bfs
     * BFS is much better here, rather than a DFS approach.
     * Sure, the solution here is short in terms of lines of code and looks nice, but it's far from optimal.
     * If you have a tree where say the root's left subtree has a depth of 500 and the right subtree has a depth of 1,
     * the code is going to traverse all the way down the 500 left subtree first before finally traversing the right subtree
     * with a measly depth of 1 and figuring out "d'oh!" that's the min depth. With BFS, instead of traversing 501 nodes to
     * figure out the min depth, you could've just traversed two. Now imagine if the left subtree comprised of tens of
     * thousands of nodes
     */
    private int bfs(TreeNode root) {
        /*  Approach: bfs + iterative
            Time Complexity: O(2 ^ minDepth)
            Space Complexity: O(2 ^ minDepth)
        */

        if(root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while(!queue.isEmpty()) {

            level++;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if(node.left == null && node.right == null) {
                    return level;
                }

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return level;
    }

}
