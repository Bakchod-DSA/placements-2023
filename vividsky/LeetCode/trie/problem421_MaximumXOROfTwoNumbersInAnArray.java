package LeetCode.trie;

/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * Difficulty level : Medium
 */

class TrieNode {
    TrieNode[] links;
    public TrieNode() {
        links = new TrieNode[2];
    }
}

public class problem421_MaximumXOROfTwoNumbersInAnArray {
    TrieNode root = new TrieNode();
    public int findMaximumXOR(int[] nums) {
        create(nums);

        int maxXor = 0;
        int temp = 0;

        for (int ele: nums) {
            TrieNode pCrawl = root;
            temp = 0;
            for (int i = 31; i >= 0; i--) {

                int bit = ((ele >> i) & 1);

                if (pCrawl.links[bit ^ 1] != null) {
                    temp |= (1 << i);
                    pCrawl = pCrawl.links[bit ^ 1];
                } else {
                    pCrawl = pCrawl.links[bit];
                }
            }
            maxXor = Math.max(maxXor, temp);

        }
        return maxXor;
    }

    private void create(int[] nums) {
        for (int ele: nums) {
            TrieNode pCrawl = root;
            for (int i = 31; i >= 0; i--) {
                if (pCrawl.links[((ele >> i) & 1)] == null) {
                    pCrawl.links[((ele >> i) & 1)] = new TrieNode();
                }
                pCrawl = pCrawl.links[((ele >> i) & 1)];
            }
        }
    }
}
