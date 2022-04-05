/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
 * Difficulty level: Medium
 */

package leetcode.Tree.BinarySearchTree;

import java.util.*;

public class Problem1305_AllElementsInTwoBST {

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // return approachOne(root1, root2);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        inorder(root1, list1);
        inorder(root2, list2);
        return mergeTwoSortedArraysUsingHeap(list1, list2);
    }

    private List<Integer> approachOne(TreeNode root1, TreeNode root2) {
        /*  Approach: stack
            Time Complexity: O(m + n); m = number of nodes in root1, n = number of nodes in root2
            Space Complexity: O(h1 + h2), h1,h2 are respective heights of tree1 and tree2.
        */

        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<Integer> sorted = new ArrayList<>();

        while(root1 != null || !stack1.isEmpty() || root2 != null || !stack2.isEmpty()) {
            while(root1 != null) {
                stack1.push(root1);
                root1 = root1.left;
            }

            while(root2 != null) {
                stack2.push(root2);
                root2 = root2.left;
            }

            if(!stack1.isEmpty() && !stack2.isEmpty()) {
                if(stack1.peek().val < stack2.peek().val) {
                    sorted.add(stack1.peek().val);
                    root1 = stack1.pop().right;
                } else {
                    sorted.add(stack2.peek().val);
                    root2 = stack2.pop().right;
                }
            } else if(stack1.isEmpty() && !stack2.isEmpty()) {
                root2 = stack2.pop();
                sorted.add(root2.val);
                root2 = root2.right;
            } else if(!stack1.isEmpty() && stack2.isEmpty()) {
                root1 = stack1.pop();
                sorted.add(root1.val);
                root1 = root1.right;
            }

        }

        return sorted;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        /*  Approach: brute force
            Time Complexity: O(m + n); m = number of nodes in root1, n = number of nodes in root2
            Space Complexity: O(h1 + h2 + m + n), h1,h2 are respective heights of tree1 and tree2, m,n for lists
        */

        if(root == null) {
            return;
        }

        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    private List<Integer> mergeTwoSortedArrays(List<Integer> list1, List<Integer> list2) {
        /*  Approach: brute force, pointers
            Time Complexity: O(m + n); m = number of nodes in root1, n = number of nodes in root2
            Space Complexity: O(1)
        */

        List<Integer> sorted = new ArrayList<>();

        int p1, p2;
        for(p1 = 0, p2 = 0; p1 < list1.size() && p2 < list2.size(); ) {
            if(list1.get(p1) < list2.get(p2)) {
                sorted.add(list1.get(p1));
                p1++;
            } else {
                sorted.add(list2.get(p2));
                p2++;
            }
        }
        if(p1 == list1.size()) {
            for(; p2 < list2.size(); p2++) {
                sorted.add(list2.get(p2));
            }
        }
        if(p2 == list2.size()) {
            for(; p1 < list1.size(); p1++) {
                sorted.add(list1.get(p1));
            }
        }

        return sorted;
    }


    private List<Integer> mergeTwoSortedArraysUsingHeap(List<Integer> list1, List<Integer> list2) {
        /*  Approach: brute force, heap
            Time Complexity: O(m + n); m = number of nodes in root1, n = number of nodes in root2
            Space Complexity: O(2), heap can have atmost two elements.
        */

        List<Integer> sorted = new ArrayList<>();
        Queue<Pair> minHeap = new PriorityQueue<>((pair1, pair2) -> pair1.getFirst() - pair2.getFirst());
        if(!list1.isEmpty()) minHeap.add(new Pair(list1.get(0), 0, 0));
        if(!list2.isEmpty()) minHeap.add(new Pair(list2.get(0), 0, 1));

        while(!minHeap.isEmpty()) {

            Pair toAdd = minHeap.remove();

            sorted.add(toAdd.getFirst());
            int index = toAdd.getIndex();
            int array = toAdd.getArray();
            if(array == 0 && index < list1.size() - 1) {
                minHeap.add(new Pair(list1.get(index + 1), index + 1, array));
            } else if(array == 1 && index < list2.size() - 1) {
                minHeap.add(new Pair(list2.get(index + 1), index + 1, array));
            }
        }
        return sorted;
    }

    public class Pair {
        private int first;
        private int index;
        private int array;

        Pair(int first, int index, int array) {
            this.first = first;
            this.index = index;
            this.array = array;
        }

        public int getFirst() {
            return first;
        }

        public int getIndex() {
            return index;
        }

        public int getArray() {
            return array;
        }

        public String toString() {
            return "first: " + first + " index: " + index + " array: " + array;
        }
    }
}
