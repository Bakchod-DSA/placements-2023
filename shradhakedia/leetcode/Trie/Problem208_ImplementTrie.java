/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/implement-trie-prefix-tree/
 * Difficulty level : Medium
 */

package leetcode.Trie;

import java.util.*;

public class Problem208_ImplementTrie {
    /*  Approach: Implementation of Trie
        Time complexity :  O(m), where m is the word length.
        Space complexity : O(alphabet_size * length of word * no. of words).
    */

    TrieNode root;

    private static class TrieNode {

        private static final int ALPHABET_SIZE = 26;

        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[ALPHABET_SIZE];
            isEndOfWord = false;

        }

        @Override
        public String toString() {
            return "Trie node : " + Arrays.toString(children) + " is end of word? : " + isEndOfWord + ". ";
        }

    }

    public Problem208_ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        // Time complexity :  O(m), where m is the key length.

        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(temp.children[ch - 'a'] == null) {
                temp.children[ch - 'a'] = new TrieNode();
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isEndOfWord = true;

    }

    public boolean search(String word) {
        // Time complexity :  O(m), where m is the key length.

        TrieNode temp = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if(temp.children[ch - 'a'] == null) {
                return false;
            }
            temp = temp.children[ch - 'a'];
        }
        return temp.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        // Time complexity :  O(m), where m is the key length.

        TrieNode temp = root;

        for(int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);

            if(temp.children[ch - 'a'] == null) {
                return false;
            }
            temp = temp.children[ch - 'a'];
        }

        return true;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Problem208_ImplementTrie obj = new Problem208_ImplementTrie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */