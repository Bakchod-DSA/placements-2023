# Trie (Prefix Tree)

## Introduction
- Trie is an efficient Data structure to use when taking about Strings. Its application are dictionary, spell check, Auto 
  Fill. 
- Why is it efficient? because it stores words in such way that two words sharing some common prefix
  are placed on single trie node, and diverge as they start getting differed going along the trie. **(There are other reasons 
  too why it is efficient. We will discuss it later).**
- How to understand it? Let's take an example of two such words "hell" "help", the two share common prefix "hel".
            
        Trie structure will be something like this:
                            root
                             |
                             h
                             |
                             e
                             |
                             l
                           /   \
                          l     p

- Creating this type of structure, it is very fast to insert and search a word in trie. suppose we want to insert "he" now
  its to easy to just mark a sign sort of thing on 'e' denoting it's the end of a word. whereas hashtable stores he, hell, help 
  separately.
- Binary Tree searches for a word in m * log(n) time, where m is the length of word to search, n is the height of tree,
  whereas a Hash table searches a word in O(h) time, where h is time taken to hash the string, 
  but when we talk about trie it searches in O(m) time, where m is the length of word to search.
- Trie is useful in places where there are complex prefix searches for a word again and again, trie searches it very fast in O(m).
  And, a hashtable takes a time of searching each prefix formed by a word again and again,
  like to check hel is prefix of help, first we check h is prefix or not, then 'he', then 'hel', 
  but, in trie simply 'h', then 'e' and then 'l'.

## Structure of a Trie
 - A Trie consists of a root of type Trie node. The Trie node has two properties.
   - An array of trie node of size as alphabet_size.
   - A boolean signifying if this node denotes the end of a word stored in trie.
 - The root node has an array (of type TrieNode) of 26 length and all the entries in the array are null
   at the start, this root has boolean set to false for end of word. as no entries have been made in trie.
 - Storing a word "help" in Trie, Why have we made an array of size 26? The role comes in here.
   Each index denotes a single character of english alphabet, and they are mapped like 'a' -> 0, 'b' -> 1, 'c' -> 2,
   ... 'z' -> 25, as we get "help" we begin by storing 'h' first, so in root at index **['h' - 'a']** we make a new trie 
   node. while other entries of root array remains null, this tells we have stored a char 'h' now,
   then comes to store 'e' so firstly we point our pointer to the newly made node 'h' now and in this we make a new trie node 
   at index **['e' - 'a']**. Now, the root has a trie node of 'h' and 'h' has a trie node of 'e', following this pattern 
   we stored 'help' but after storing this. the pointer at 'p' also has a boolean property signifying end of word, so we 
   mark it as true. now, next time if we store "he" we traverse the root to see already trie node at 'h' is there, //ly 
   at 'e' of 'h' trie node. so we simply mark 'e' as end of word. It's that easy to store the words. and assuming, the 
   English language can have the longest word of almost 50 size, so trie height will not exceed this then.
   
## Implementation (Template)

        public class Trie {
            
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
                    char ch = key.charAt();
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
                    char ch = key.charAt();
                    if(crawl.children[ch - 'a'] == null) {
                        return false;
                    }
                    crawl = crawl.children[ch - 'a'];
                }
                return crawl.isEnd;
            }

            private boolean isPrefix(String prefix) {
                TrieNode crawl = root;

                for(int i = 0; i < prefix.length(); i++) {
                    char ch = prefix.charAt();
                    if(crawl.children[ch - 'a'] == null) {
                        return false;
                    }
                    crawl = crawl.children[ch - 'a'];
                }
                return true;
            }

            public static void main(String[] args) {
                Trie obj = new Trie();
                obj.insert(word);
                boolean param_2 = obj.search(word);
                boolean param_3 = obj.startsWith(prefix);
            }
        }
