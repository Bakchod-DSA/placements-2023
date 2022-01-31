/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/replace-words/
 * Difficulty level : Medium
 */

package leetcode.Trie;

import java.util.*;

public class Problem648_ReplaceWords {

    public String replaceWords(List<String> dictionary, String sentence) {

        // return approachOne(dictionary, sentence);
        return approachTwo(dictionary, sentence);
    }

    private String approachOne(List<String> dictionary, String sentence) {
        /*  Approach: Trie
        Time complexity  : O(sum(p) + sum(p)), where first is to add the dictionary's words, p is
                           length of word in sentence, other is to query each word
        Space complexity : O(alphabet_size * length of word * no. of words) or O(trie size).
        */

        Trie obj = new Trie();
        for(String word : dictionary) {
            obj.insert(word);
        }

        StringBuilder result = new StringBuilder();

        for(String word : sentence.split(" ")) {
            String prefix = obj.search(word);
            if(prefix.isEmpty()) {
                result.append(word).append(" ");
            } else {
                result.append(prefix).append(" ");
            }
        }

        return result.substring(0, result.length() - 1);
    }

    class TrieNode {

        final int ALPHABET_SIZE = 26;

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

    class Trie {
    /*  Approach: Implementation of Trie
        Time complexity :  O(m), where m is the word length.
        Space complexity : O(alphabet_size * length of word * no. of words).
    */

        TrieNode root;

        public Trie() {
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

        public String search(String word) {
            // Time complexity :  O(m), where m is the key length.

            StringBuilder wordPrefix = new StringBuilder();

            TrieNode temp = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);

                if(temp.children[ch - 'a'] == null) {
                    return "";
                } else {
                    wordPrefix.append(ch);
                    if(temp.children[ch - 'a'].isEndOfWord) {
                        return wordPrefix.toString();
                    }

                }
                temp = temp.children[ch - 'a'];
            }

            return wordPrefix.toString();
        }

    }

    private String approachTwo(List<String> dictionary, String sentence) {
        /*  Approach: HashSet
        Time complexity  : O(m + sum(p*(p + 1)/2)), where m is the dictionary's length, p is length of word
                           in sentence.
        Space complexity : O(n), n is set size.
        */

        Set<String> set = new HashSet<>(dictionary);

        StringBuilder result = new StringBuilder();
        for(String word : sentence.split(" ")) {
            StringBuilder prefix = new StringBuilder();
            for(int i = 0; i < word.length(); i++) {
                prefix.append(word.charAt(i));
                if(set.contains(prefix.toString())) {
                    break;
                }
            }
            result.append(prefix).append(" ");
        }

        return result.substring(0, result.length() - 1);
    }

}
