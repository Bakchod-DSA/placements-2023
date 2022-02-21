/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/top-k-frequent-words/
 * Difficulty level: Medium
 */

package leetcode.Heap;

import java.util.*;

public class Problem692__TopKFrequentWords__ {

    public List<String> topKFrequent(String[] words, int k) {
        return approachOne(words, k);
    }

    private List<String> approachOne(String[] words, int k) {
        /* Approach: Heap(Priority Queue)
           Time Complexity: O(n + nlogk)
           Space Complexity: O(n + k)
        */

        // 1. build HashMap
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        // 2. build min heap of size k
        Queue<String> minHeap = new PriorityQueue<>(k, (s1, s2) -> (map.get(s1) == map.get(s2))? s2.compareTo(s1) : map.get(s1) - map.get(s2));
        for(Map.Entry<String, Integer> entryset : map.entrySet()) {
            minHeap.add(entryset.getKey());

            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // 3. build your answer
        String[] ans = new String[k];
        for(int i = k - 1; i >= 0; i--) {
            ans[i] = minHeap.poll();
        }

        return Arrays.asList(ans);

    }

    private List<String> approachTwo(String[] words, int k) {
        /* Approach: Trie + bucketSort
           Time Complexity: O(n + nm), n for adding in hashmap, n for adding in tie and  m time to construct trie for each word
                            and m is a constant.
           Space Complexity: O(n + nm), n for hashmap, m space for each bucket and m is a constant. at max m is 26.
        */

        // 1. build HashMap
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        // 2. build buckets sorting according to frequency
        Trie[] bucket = new Trie[words.length + 1];
        for(Map.Entry<String, Integer> entryset : map.entrySet()) {
            int freq = entryset.getValue();
            String word = entryset.getKey();

            if(bucket[freq] == null) {
                bucket[freq] = new Trie();
            }
            bucket[freq].add(word);
        }

        // 3. build ans
        List<String> ans = new ArrayList<>();
        for(int i = bucket.length - 1; i >= 0; i--) {
            //for trie in each bucket, get all the words with same frequency in lexicographic order. Compare with k and get the result

            if(bucket[i] != null) {
                List<String> l = new ArrayList<>();
                bucket[i].getWords(bucket[i].root, l);
                if(l.size() < k) {
                    ans.addAll(l);
                    k = k - l.size();
                } else {
                    for(int j = 0; j < k; j++) {
                        ans.add(l.get(j));
                    }
                    break;
                }
            }
        }

        return ans;

    }

    class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        private void add(String word) {
            TrieNode crawl = root;
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(crawl.children[ch - 'a'] == null) {
                    crawl.children[ch - 'a'] = new TrieNode();
                }
                crawl = crawl.children[ch - 'a'];
            }

            crawl.word = word;
        }

        private void getWords(TrieNode root, List<String> l) {

            // dfs on trie to get lexicograpic order of all the words with same frequency as all left path will be
            // lexicographically smaller than right path

            if(root == null) {
                return;
            }

            if(root.word != null) {
                l.add(root.word);
            }

            for(int i = 0; i < 26; i++) {
                if(root.children[i] != null) {
                    getWords(root.children[i], l);
                }
            }

        }
    }

}
