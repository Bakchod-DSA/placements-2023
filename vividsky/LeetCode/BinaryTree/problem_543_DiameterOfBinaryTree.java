package LeetCode.BinaryTree;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/diameter-of-binary-tree/
 * Difficulty level : Easy
 */
public class problem_543_DiameterOfBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        approachTwo(root);
        return max;
    }

    /**
     Time : O(N)
     algo : we are doing same as we were doing in approachOne
     but in a single recursive call we are calculating max height of tht particular node
     and whether curr node is the node with max diameter
     */
    private int approachTwo(TreeNode root) {
        if (root == null) return 0;
        int left = approachTwo(root.left);
        int right = approachTwo(root.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }

    /**
     traversal : post order (will find diameter from left subtree then right then will compare with current node max diameter)
     approach :
     dl = diameterOfLeftSubtree()
     dr = diameterOfRightSubtree()
     diameterOfCurrentNode = maxHeightOfLeftSubtree() + maxHeightOfRightSubtree();
     return math.max(dl, dr, diameterOfCurrentNode);
     */
    public int approachOne(TreeNode root) {
        if (root == null) return 0;
        int dl = approachOne(root.left);
        int dr = approachOne(root.right);
        int cd = height(root.left) + height(root.right);
        return Math.max(dl, Math.max(dr, cd));
    }

    private int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}
