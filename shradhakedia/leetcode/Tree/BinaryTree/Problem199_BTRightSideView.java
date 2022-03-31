/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/binary-tree-right-side-view/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem199_BTRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        return bfs(root);
    }

    private List<Integer> bfs(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> rightNodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode node = queue.poll();

                if(i == size - 1) {
                    rightNodes.add(node.val);
                }

                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return rightNodes;
    }
}
