/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * Difficulty level : Medium
 */

package leetcode.Trie;

import java.util.*;

public class Problem421_MaximumXorOfTwoNumbersInAnArray {

    public int findMaximumXOR(int[] nums) {

        return approachOne(nums);
    }

    private int approachOne(int[] nums) {
        /*  Approach: Trie with Bit Manipulation
            Time Complexity:  O(32n + 32n), one 32n for inserting nums, and the other for traversing the tree to
                              find maximum xor, that number can have with any no. in array.
            Space Complexity: O(2 * 32 * n)

        */

        TrieNode root = insertNums(nums);
        int maxXor = 0;

        for(int num : nums) {

            TrieNode node = root;
            int currentMaxXor = maxXorWithNum(num, node);
            maxXor = Math.max(maxXor, currentMaxXor);
        }

        return maxXor;
    }

    private TrieNode insertNums(int[] nums) {
        /*  Time Complexity:  O(32n), inserting a num in O(32) time and total n nums.
            Space Complexity: O(2 * 32 * n), making trie object
        */

        Trie obj = new Trie();

        for(int num: nums) {
            obj.insert(num);
        }

        return obj.root;
    }

    private int maxXorWithNum(int num, TrieNode node) {
        /*  Time Complexity:  O(32n), travering trie for a single num in O(32) time and total n nums.
             Space Complexity: O(1)
        */

        int ans = 0;
        for(int level = 31; level >= 0; level--) {

            int mask = 1 << level;
            int index = 1;
            if((num & mask) == mask) {
                if(node.children[0] != null) {
                    ans |= mask;
                    node = node.children[0];
                } else {
                    node = node.children[1];
                }
            } else {
                if(node.children[1] != null) {
                    ans |= mask;
                    node = node.children[1];
                } else {
                    node = node.children[0];
                }
            }
        }

        return ans;
    }

    private class TrieNode {

        private final int size = 2;

        private TrieNode[] children;
        private boolean isEnd;

        TrieNode() {
            children = new TrieNode[size];
            isEnd = false;
        }

        @Override
        public String toString() {
            return "tree node: " + Arrays.toString(children) + ". ";
        }

    }

    private class Trie {

        private TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        private void insert(int num) {

            TrieNode node = root;
            for(int level = 31; level >= 0; level--) {

                int mask = 1 << level;
                int index = 0;
                if((num & mask) == mask) {
                    index = 1;
                }

                if(node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }

            node.isEnd = true;
        }

    }

}
