package leetcode.Recursion;

public class Problem104_MaximumDepthOfATree {

     public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
     }


    public int maxDepth(TreeNode root) {

        return approachOne(root);

    }

    private int approachOne(TreeNode root) {
        /*  Approach: Recursion
            Time Complexity: O(no. of nodes in the tree)
            Space Complexity: O(height of the tree)

        */

        if(root == null) {
            return 0;
        }
        if(root.left == null && root.right == null) {
            return 1;
        }

        int left = approachOne(root.left);
        int right = approachOne(root.right);

        return Math.max(left, right) + 1;
    }

}
