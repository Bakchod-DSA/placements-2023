package LeetCode.BinaryTree;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * Difficulty level : Medium
 */
public class Xproblem_236_LowestCommonAncestorOfABinaryTree {

    // One more approach is left

    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // approachTwo(root, p, q);
        // return ans;
        return approachThree(root, p, q);
    }

    /**
     Time : O(N)
     Algo : We will traverse the tree iteratively
     we will search till we find both p and q in tree and will keep on stroing their parents
     in dictionary(child -> parent)
     once we find both p and q -> we will add all the anscestors of p in a set and
     then check first common ancestor for both p and q

     How will we find parent of each node? -> each node will be present in dictionary,
     we will keep on storing their parents and then will make parent as our current node
     and look of its parent in dictionary
     */
    private TreeNode approachThree(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.add(root);
        map.put(root, null);

        while (!map.containsKey(p) || !map.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left != null) {
                map.put(node.left, node);
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
                map.put(node.right, node);
            }
        }

        HashSet<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = map.get(p);
        }

        while (!ancestors.contains(q)) {
            q = map.get(q);
        }
        return q;
    }

    /**
     Traversal : postorder
     Time : O(N)
     Space: O(H) worstcase -> N in case of skewed tree
     Algo : search left and right subtree for p and q
     add left + right + currNode(if currNode == p || currNode == q)
     if we have found both p and q till now (if curr == 2) this is going to be our LCA
     as it is the farthest node from root (as our approach is bottom up)
     else return if we have found any of p or q or none to its parent node to search other (if found one)
     or both (if found none) considering its parent as root
     */
    private int approachTwo(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) return 0;

        int left = approachTwo(root.left, p, q);
        int right = approachTwo(root.right, p, q);

        int curr = ((root == p || root == q) ? 1 : 0) + left + right;

        if (curr == 2 && ans == null) {
            ans = root;
        }
        return curr;
    }


    /**
     Time : O(N)
     Space : Recursive stack
     Algo : Its a top down approach where we find if current node is LCA or not by exploring its right and left subtree

     */
    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) return root;
        int left = search(root.left, p, q);
        int right = search(root.right, p, q);
        if (left == right) {
            return root;
        } else if (left == 2) {
            return dfs(root.left, p, q);
        } else {
            return dfs(root.right, p, q);
        }
    }

    private int search(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return 0;
        }
        if (root.val == p.val || root.val == q.val) {
            return 1 + search(root.left, p, q) + search(root.right, p, q);
        }
        return search(root.left, p, q) + search(root.right, p, q);

    }
}
