package LeetCode.BinaryTree;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * Difficulty level : Easy
 */
public class problem111_MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        // return dfs(root);
        return bsf(root);
    }

    private int dfs(TreeNode root) {

        if (root == null) return 0;

        int left = dfs(root.left);
        int right = dfs(root.right);

        if (left == 0 || right == 0)
            return left + right + 1;

        return Math.min(left, right) + 1;
    }

    private int bsf(TreeNode root) {

        if (root == null) return 0;

        int level = 1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (node.left == null && node.right == null)
                    return level;

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
            level++;
        }
        return level;
    }
}
