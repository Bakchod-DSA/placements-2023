package LeetCode.BinaryTree;

public class Xproblem101_SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return approachTwo(root);
    }

    /**
     Using Stack Iterative DFS
     Time : O(N)
     Space: O(2*N)
     Algo : Since we are using STack -> our code is running DFS on both sides symmetrically
     keep addying left and right elements and compare them before moving to its childrens
     at end -> return true as all the elements are symmentric and haing same values
     */
    private boolean approachThree(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root.left);
        stack.add(root.right);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (left == null && right == null) {
                continue;
            } else if (left == null || right == null || right.val != left.val) {
                return false;
            }
            stack.add(left.left);
            stack.add(right.right);
            stack.add(left.right);
            stack.add(right.left);
        }
        return true;
    }

    /**
     * Recursive DFS
     Time : worst case O(N)
     Space: recursive stack
     Algo : compare left and right subtree recursively
                      2
                   /    \
                 3        3
                / \      / \
              4    5    5   4
            / \   / \  / \  / \
           N  N  8  9 N  N  9 8
     comparison will take place 3-3 -> 4-4 -> N-8 -> N-9 -> 5-5 -> 8-N -> 9-N


     */
    private boolean approachTwo(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode subTree0, TreeNode subTree1) {
        if (subTree0 == null && subTree1 == null) {
            return true;
        }
        if (subTree0 != null && subTree1 != null) {
            return subTree0.val == subTree1.val
                    && isSymmetric(subTree0.left, subTree1.right)
                    && isSymmetric(subTree0.right, subTree1.left);
        }
        return false;
    }

    /**
      Queue Iterative BFS
     Time : O(N)
     leftBfs and rightBFS will return left and right mirror images in O(2N) as we are also storing
     null childrens of leaf nodes and in worst case childrens of leaf nodes can be N + 1
     Space: O(2*N) + recursive stack
     Algo : Apply BFS on both sides of root and store elements in an array, later compare those arrays

     */
    private boolean approachOne(TreeNode root) {

        List<Integer> left = leftBFS(root.left);
        List<Integer> right = rightBFS(root.right);

        return left.equals(right);
    }

    private List<Integer> leftBFS(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode ele = queue.poll();
            if (ele == null) {
                list.add(null);
            } else {
                list.add(ele.val);
            }
            if (ele != null) {
                queue.add(ele.left);
                queue.add(ele.right);
            }

        }
        return list;
    }

    private List<Integer> rightBFS(TreeNode node) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode ele = queue.poll();
            if (ele == null) {
                list.add(null);
            } else {
                list.add(ele.val);
            }
            if (ele != null) {
                queue.add(ele.right);
                queue.add(ele.left);
            }

        }
        return list;
    }
}
