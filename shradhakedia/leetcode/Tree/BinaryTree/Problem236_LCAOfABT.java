package leetcode.Tree.BinaryTree;

import java.util.*;

public class Problem236_LCAOfABT {

    TreeNode ans = null;

    // Three static flags to keep track of post-order traversal.

    // Both left and right traversal pending for a node.
    // Indicates the nodes children are yet to be traversed.
    private static int BOTH_PENDING = 2;

    // Left traversal done.
    private static int LEFT_DONE = 1;

    // Both left and right traversal done for a node.
    // Indicates the node can be popped off the stack.
    private static int BOTH_DONE = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // return approachOne(root, p, q);

        // approachTwo(root, p, q);
        // return ans;

         return approachThree(root, p, q);

        // return approachFour(root, p, q);
    }

    private TreeNode approachOne(TreeNode root, TreeNode p, TreeNode q) {
        /*  Approach: Brute Force
            Time Complexity: O(n ^ 2)
            Space Complexity: O(h)
        */

        int lt = count(root.left, p, q);
        int rt = count(root.right, p, q);

        if(lt == 2) return approachOne(root.left, p, q);
        else if(rt == 2) return approachOne(root.right, p, q);
        else if((lt == 1 || rt == 1) && (root.val == p.val || root.val == q.val)) {
            return root;
        } else {
            // both lt = 1 and rt == 1 but root.val != p or q
            return root;
        }
    }

    private int count(TreeNode root, TreeNode p, TreeNode q) {
        /* Time Complexity: O(n)
           Space Complexity: O(h)
        */

        if(root == null) {
            return 0;
        }
        if(root.val == p.val) {
            return 1 + count(root.left, p, q) + count(root.right, p, q);
        }
        if(root.val == q.val) {
            return 1 + count(root.left, p, q) + count(root.right, p, q);
        }
        return count(root.left, p, q) + count(root.right, p, q);

    }

    private boolean approachTwo(TreeNode root, TreeNode p, TreeNode q) {
        /*  Approach: Recursion
            Time Complexity: O(n)
            Space Complexity: O(h)
        */

        if(root == null) {
            return false;
        }
        int mid = (root.val == p.val || root.val == q.val)? 1 : 0;
        int left = approachTwo(root.left, p, q)? 1 : 0;
        int right = approachTwo(root.right, p, q)? 1 : 0;

        if(mid + left + right >= 2) {
            ans = root;
        }

        return (mid + left + right > 0);
    }

    private TreeNode approachThree(TreeNode root, TreeNode p, TreeNode q) {
        /*  Approach: Iterative using parent pointers
            Time Complexity: O(2n)
            Space Complexity: O(3n), worst case. otherwise, its the height of the tree space used by the stack, map, set.
        */

        // Stack for tree traversal
        Stack<TreeNode> stack = new Stack<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        stack.push(root);
        parent.put(root, null);

        // Iterate until we find both the nodes p and q
        while(!parent.containsKey(p) || !parent.containsKey(q)) {
            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if(node.left != null) {
                stack.push(node.left);
                parent.put(node.left, node);
            }
            if(node.right != null) {
                stack.push(node.right);
                parent.put(node.right, node);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while(p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in p's ancestor set() is their lowest common ancestor.
        while(q != null) {
            if(ancestors.contains(q)) {
                ans = q;
                break;
            } else {
                q = parent.get(q);
            }
        }

        return ans;
    }

    /*
    private TreeNode approachFour(TreeNode root, TreeNode p, TreeNode q) {
        /*  Approach: Iterative without parent pointers
            Time Complexity:  O(n), The advantage of this approach is that we can prune backtracking. We simply return once
                              both the nodes are found.
            Space Complexity: O(n), worst case. otherwise, its the height of the tree space used by the stack, map, set.


        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        // This flag is set when either one of p or q is found.
        boolean oneNodeFound = false;

        // This is used to keep track of the LCA.
        TreeNode LCA = null;

        // child node
        TreeNode curr = null;

        // Initialize the stack with the root node.
        stack.push(new Pair<>(root, Solution.BOTH_PENDING));

        // We do a post order traversal of the binary tree using stack
        while(!stack.isEmpty()) {
            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parentNode = top.getKey();
            int parentState = top.getValue();

            // If the parent_state is equal to BOTH_DONE, this means the parent_node can be popped off.
            if(parentState == BOTH_DONE) {
                // the top node could be popped off the stack. Update the LCA node to be the next top node.
                if(LCA == stack.pop().getKey() && oneNodeFound) {
                    LCA = stack.peek().getKey();
                }
            } else {

                // If both child traversals are pending
                if(parentState == BOTH_PENDING) {

                    // Check if the current parent_node is either p or q.
                    if(parentNode.val == p.val || parentNode.val == q.val) {
                        if(oneNodeFound) {
                            // If one_node_found was set already, this means we have found both the nodes.
                            return LCA;
                        }
                        // Otherwise, set one_node_found to True, to mark one of p and q is found.
                        oneNodeFound = true;

                        // Save the current top element of stack as the LCA.
                        LCA = stack.peek().getKey();
                    }

                    // If both pending, traverse the left child first
                    curr = parentNode.left;
                } else {
                    // otherwise traverse right child
                    curr = parentNode.right;
                }

                // Update the node state at the top of the stack.Since we have visited one more child.
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parentNode, parentState - 1));

                // Add the child node to the stack for traversal.
                if(curr != null) {
                    stack.push(new Pair<>(curr, Solution.BOTH_PENDING));
                }
            }

        }

        return null;
    }
    */

}
