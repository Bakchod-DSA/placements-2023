/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-mode-in-binary-search-tree/
 * Difficulty level: Easy
 */

package leetcode.Tree.BinarySearchTree;

import java.util.*;

public class Problem501_ModeInBST {

    LinkedList<Pair> modes = new LinkedList<>();
    TreeNode prev = null;
    int count = 1;

    public int[] findMode(TreeNode root) {

        TreeNode prev = inorder(root);

        // for checking the count of last appeared node.
        if(!modes.isEmpty()) {
            if(modes.get(0).getValue() < count) {
                modes.clear();
                modes.add(new Pair(prev.val, count));
            } else if(modes.get(0).getValue() == count) {
                modes.add(new Pair(prev.val, count));
            }
        } else {
            modes.add(new Pair(prev.val, count));
        }

        int[] ans = new int[modes.size()];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = modes.removeFirst().getKey();
        }

        return ans;
    }

    private TreeNode inorder(TreeNode root) {
        /*  Approach: recursive inorder
            Time Complexity: O(n)
            Space Complexity: O(1), since its given in follow up to not to count recursive space. modes is
                              used to store answer so we don't count its space too.
        */

        if(root == null) {
            return null;
        }

        inorder(root.left);

        // increment count on getting same value, else add it to the list if count is more or
        // equal to previous pairs.
        if(prev != null) {
            if(prev.val == root.val) {
                count++;
            } else {
                if(!modes.isEmpty()) {
                    if(modes.get(0).getValue() < count) {
                        modes.clear();
                        modes.add(new Pair(prev.val, count));
                    } else if(modes.get(0).getValue() == count) {
                        modes.add(new Pair(prev.val, count));
                    }
                } else {
                    modes.add(new Pair(prev.val, count));
                }
                count = 1;
            }
        }

        prev = root;

        inorder(root.right);

        return prev;
    }


    class Pair {
        int key, value;
        Pair(int k, int v) {
            key = k;
            value = v;
        }

        int getValue() {
            return value;
        }

        int getKey() {
            return key;
        }
    }
}
