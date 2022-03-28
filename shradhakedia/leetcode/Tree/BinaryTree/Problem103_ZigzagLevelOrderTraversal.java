/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem103_ZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // return approachOne(root);
        return approachTwo(root);
    }

    private List<List<Integer>> approachOne(TreeNode root) {
        /*  Approach: bfs + iteration
            Time Complexity: O(n + 2^h)
            Space Copmplexity: O(n)
        */

        if(root == null) {
            return new ArrayList<>();
        }

        List<List<Integer>> zigzaglevels = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        boolean leftToRight = false;

        queue.add(root);
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            leftToRight = !leftToRight;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(leftToRight) {
                    level.add(node.val);
                } else {
                    level.add(0, node.val);
                }

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }

            zigzaglevels.add(level);
        }

        return zigzaglevels;
    }

    private List<List<Integer>> approachTwo(TreeNode root) {
        /*  Approach: bfs + iteration
            Time Complexity: O(2n)
            Space Copmplexity: O(n + 2^h)
        */

        if(root == null) {
            return new ArrayList<>();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> zigzaglevels = new ArrayList<>();
        boolean leftToRight = false;

        zigzaglevels.add(new ArrayList<>(Arrays.asList(root.val)));
        stack.push(root);

        while(!stack.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> temp = new ArrayList<>();
            int size = stack.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = stack.pop();
                if(leftToRight) {
                    if(node.left != null) {
                        temp.add(node.left);
                    }
                    if(node.right != null) {
                        temp.add(node.right);
                    }
                } else {
                    if(node.right != null) {
                        temp.add(node.right);
                    }
                    if(node.left != null) {
                        temp.add(node.left);
                    }
                }
            }
            stack.addAll(temp);

            for(TreeNode nodes : temp) {
                level.add(nodes.val);
            }
            leftToRight = !leftToRight;
            if(!level.isEmpty()) {
                zigzaglevels.add(level);
            }
        }

        return zigzaglevels;
    }
}
