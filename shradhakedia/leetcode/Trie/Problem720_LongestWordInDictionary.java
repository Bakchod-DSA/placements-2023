/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/longest-word-in-dictionary/
 * Difficulty level : Medium
 */

package leetcode.Trie;

import java.util.*;

public class Problem720_LongestWordInDictionary {

    public String longestWord(String[] words) {
        // return approachOne(words);
        // return approachTwo(words);
        return approachThree(words);
    }

    public String approachOne(String[] words) {
        /*  Approach: HashSet + Brute Force
            Time Complexity:  O(n + Σw^2 + nw), one n to insert, one Σw^2 to search all prefixes of each word and
                              n * w to choose lexicographically small, where w is length of word, n is the length of array.
                              ignoring compareTo complexity, O(n + Σw^2).
            Space Complexity: O(n)
        */

        HashSet<String> set = new HashSet<>(Arrays.asList(words));

        String ans = "";
        for(String word : words) {
            boolean good = true;
            for(int i = 1; i < word.length(); i++) {
                if(!set.contains(word.substring(0, i))) {
                    good = false;
                    break;
                }
            }
            if(good) {
                if(ans.length() < word.length() || ans.length() == word.length() && word.compareTo(ans) < 0) {
                    ans = word;
                }
            }
        }

        return ans;
    }

    public String approachTwo(String[] words) {
        /*  Approach: Trie + Brute Force
            Time Complexity:  O(2 * Σw + n * w), one Σw to insert, one Σw to search and n * w to choose
                              lexicographically small(compareTo), where w is length of word, n is the length of array.
                              ignoring compareTo complexity, O(2 * Σw).

            Space Complexity: O(Σw)
        */

        Trie obj = new Trie();
        for(String word : words) {
            obj.insert(word);
        }

        String ans = "";
        for(String word : words) {
            boolean hasAllPrefix = obj.search(word);
            if(hasAllPrefix) {
                if(ans.length() < word.length() || ans.length() == word.length() && word.compareTo(ans) < 0) {
                    ans = word;
                }
            }
        }
        return ans;
    }

    public String approachThree(String[] words) {
        /* Approach: Trie
           Time Complexity: O(nlogn + Σw), n is length of words array, w's are words in the array.
           Space Complexity: O(Σw)
        */

        Trie obj = new Trie();

        // sorting in the ascending order of lengths -> a, ab,abc and if length equal then store lexicographically larger
        // first -> apply, apple.
        Arrays.sort(words, (a, b) -> a.length() == b.length()? b.compareTo(a) : a.length() - b.length());

        String ans = "";
        for(String word : words) {
            boolean check = obj.insertOnlyValidWord(word);
            if(check) {
                ans = word;
            }
        }
        return ans;

    }

    public static class Trie {

        TrieNode root;

        private static class TrieNode {
            private static final int ALPHABET_SIZE = 26;
            private TrieNode[] children;
            private boolean isEnd;

            TrieNode() {
                children = new TrieNode[ALPHABET_SIZE];
                isEnd = false;
            }
        }

        public Trie() {
            root = new TrieNode();
        }

        private void insert(String key) {
            TrieNode crawl = root;

            for(int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                if(crawl.children[ch - 'a'] == null) {
                    crawl.children[ch - 'a'] = new TrieNode();
                }
                crawl = crawl.children[ch - 'a'];
            }
            crawl.isEnd = true;
        }

        private boolean search(String key) {
            TrieNode crawl = root;

            for(int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                if(crawl.children[ch - 'a'] == null) {
                    return false;
                } else if(!crawl.children[ch - 'a'].isEnd) {
                    return false;
                }
                crawl = crawl.children[ch - 'a'];
            }
            return crawl.isEnd;
        }

        /**
         * This Method is used in approach three.
         * here, we store a word normally if its of one length. But if a word is of length > 1 then we check if we have
         * already stored all its possible prefixes. if yes, we insert it. if no, we return false, by not inserting that
         * word. The logic works because arrays is sorted according to length ascending order. if length is same we have
         * stored the lexicographically smaller later, so that we check it at last and return that as the answer itself.
         */
        private boolean insertOnlyValidWord(String key) {

            TrieNode crawl = root;

            for(int i = 0; i < key.length(); i++) {
                char ch = key.charAt(i);
                if(crawl.equals(root) && crawl.children[ch - 'a'] == null) {
                    // for root we simply need to insert char
                    crawl.children[ch - 'a'] = new TrieNode();
                } else if(!crawl.equals(root)) {
                    // but if it is not the root, we need to check if the prefix of the key is already stored in Trie
                    // or not.
                    if(!crawl.isEnd) {
                        // prefix of key is not in trie, its not valid answer
                        return false;
                    } else if(crawl.children[ch - 'a'] == null){
                        // prefix of key is in trie, it can be a valid answer, so store the key in the trie.
                        crawl.children[ch - 'a'] = new TrieNode();
                    }
                }
                // moving pointer
                crawl = crawl.children[ch - 'a'];
            }
            // signifying that key has ended now.
            crawl.isEnd = true;

            // if no issue in the above cases means insertion was done properly and key is valid candidate for answer.
            return true;
        }
    }

}
