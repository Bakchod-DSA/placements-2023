package LeetCode.trie;

/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/replace-words/
 * Difficulty level : Medium
 */

class TrieNode {
    TrieNode[] links;
    String word;

    public TrieNode() {
        links = new TrieNode[26];
    }
}

public class problem648_ReplaceWords {
    public String replaceWords(List<String> dictionary, String sentence) {

        TrieNode root = create(dictionary);
        StringBuilder sb = new StringBuilder();

        for (String ele : sentence.split(" ")) {

            TrieNode pCrawl = root;

            for (char ch: ele.toCharArray()) {
                if (pCrawl.word != null || pCrawl.links[ch - 'a'] == null) {
                    break;
                }
                pCrawl = pCrawl.links[ch - 'a'];
            }
            sb.append((pCrawl.word != null ? pCrawl.word : ele) + " ");
        }
        return sb.toString().strip();
    }

    private TrieNode create(List<String> dictionary) {

        TrieNode root = new TrieNode();

        for (String word: dictionary) {

            TrieNode pCrawl = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (pCrawl.links[index] == null) {
                    pCrawl.links[index] = new TrieNode();
                }
                pCrawl = pCrawl.links[index];
            }
            pCrawl.word = word;
        }
        return root;
    }
}
