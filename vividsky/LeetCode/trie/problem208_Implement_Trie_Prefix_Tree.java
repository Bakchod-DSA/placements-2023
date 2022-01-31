package LeetCode.trie;

class TrieNode {

    private final int R = 26;
    private TrieNode[] links = new TrieNode[R];
    private boolean isLeafNode;

    public TrieNode() {
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    public void put(char ch, TrieNode trie) {
        links[ch - 'a'] = trie;
    }

    public TrieNode get(char ch) {
        return links[ch - 'a'];
    }

    public void setLeafNode() {
        isLeafNode = true;
    }

    public boolean isLeafNode() {
        return isLeafNode;
    }

}

public class problem208_Implement_Trie_Prefix_Tree {

    TrieNode root = new TrieNode();

    public void insert(String word) {

        TrieNode pCrawl = root;

        for (int i = 0; i < word.length(); i++) {

            char ch = word.charAt(i);

            if (!pCrawl.containsKey(ch)) {
                pCrawl.put(ch, new TrieNode());
            }

            pCrawl = pCrawl.get(ch);
        }
        pCrawl.setLeafNode();
    }

    public boolean search(String word) {

        TrieNode pCrawl = searchPrefix(word, root);

        return pCrawl != null ? pCrawl.isLeafNode() : false;
    }

    public boolean startsWith(String prefix) {

        TrieNode pCrawl = searchPrefix(prefix, root);

        return pCrawl != null ? true : false;
    }

    private TrieNode searchPrefix(String prefix, TrieNode pCrawl) {
        for (int i = 0; i < prefix.length(); i++) {

            char ch = prefix.charAt(i);

            if (!pCrawl.containsKey(ch)) {
                return null;
            }
            pCrawl = pCrawl.get(ch);
        }
        return pCrawl;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

