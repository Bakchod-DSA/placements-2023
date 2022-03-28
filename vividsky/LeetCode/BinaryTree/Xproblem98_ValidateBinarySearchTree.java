package LeetCode.BinaryTree;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/validate-binary-search-tree/
 * Difficulty level : Medium
 */
public class Xproblem98_ValidateBinarySearchTree {
    TreeNode prev;
    public boolean isValidBST(TreeNode root) {
        prev = null;
        // return inorder(root);
        // return approachTwo(root);
        return approachThree(root);
        // return approachFour(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     Time : O(N)
     Space: worst case -> O(N), average case -> O(Log(N))
     Algo : We are giving range for each BST such that value of all nodes in that BST will lie in that range
     For whole BST range = [Long.MIN_VALUE, LOng.MAX_VALUE]
     then we do inorder traversal modifying range for each subtree
     for left subtree, range will be [parent min, parent nod value - 1]
     for right subtree, range will be [parent nod value + 1, parent max]
     current root value should lie in its respective range
     */
    private boolean approachFour(TreeNode root, long min, long max) {

        if (root == null) return true;

        boolean left = approachFour(root.left, min, (long) root.val - 1);

        if (root.val < min || root.val > max) {
            return false;
        }
        return left && approachFour(root.right, (long) root.val + 1, max);
    }

    private boolean approachThree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = approachThree(root.left);
        if (prev != null && prev.val >= root.val) {
            return false;
        }
        prev = root;
        return left && approachThree(root.right);
    }

    /**
     Time : O(N)
     Space: average O(Log(N)), worst(skewed tree) -> O(N)
     ALgo : Since we know that inorder traversal of bst is sorted in ascending order,
     we run inorder traversal on bst and compare current node val with previous node val
     */
    private boolean approachTwo(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.add(root);
                root = root.left;
            }
            root = stack.pop();
            if (prev != null && prev.val >= root.val) {
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }

    /**
     DFS
     Time : O(N^2)
     for each node, we are finding the smallest node in its right and largest node in its left which takes               O(N), since we are finding it for each node -> O(N^2)
     Space: Recursive stack + O(N) size of queue to find min and max in right and left respectively
     Algo : Check whether left and right subtree is valid bst or not, if yes, check wheather node value is valid of              not
     */
    private boolean inorder(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean l = inorder(root.left);
        boolean r = inorder(root.right);
        long left = root.left != null ? maximum(root.left) : Long.MIN_VALUE;
        long right = root.right != null ? minimum(root.right) : Long.MAX_VALUE;
        return  l && r && left < root.val && root.val < right;
    }


    //To find minimum element
    private int minimum(TreeNode node) {
        int ans = Integer.MAX_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode ele = queue.poll();
            ans = Math.min(ans, ele.val);
            if (ele.left != null) {
                queue.add(ele.left);
            }
            if (ele.right != null) {
                queue.add(ele.right);
            }
        }
        return ans;
    }

    //To find maximum element
    private int maximum(TreeNode node) {
        int ans = Integer.MIN_VALUE;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode ele = queue.poll();
            ans = Math.max(ans, ele.val);
            if (ele.left != null) {
                queue.add(ele.left);
            }
            if (ele.right != null) {
                queue.add(ele.right);
            }
        }
        return ans;
    }
}
