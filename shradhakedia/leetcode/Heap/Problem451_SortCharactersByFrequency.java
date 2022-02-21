/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/sort-characters-by-frequency/
 * Difficulty level: Medium
 */

package leetcode.Heap;

import java.util.*;

public class Problem451_SortCharactersByFrequency {

    public String frequencySort(String s) {

        // return approachOne(s);
        // return approachTwo(s);
        return approachThree(s);
    }

    private String approachOne(String s) {
        /*  Approach: heap (Priority Queue)
            Time Complexity: O(n logk), k at max 52.
            Space Complexity: O(n + n)
        */

        // 1. Build a HashMap to store characters and their respective frequencies in a hashmap
        // O(n) time
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 2. Build a PQ where prioritizing elements that are more frequent.
        // O(nlog k) in worst case when all unique char. k will be atmost 26 small + 26 capital so log 52 = 5.7
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> map.get(c2) - map.get(c1));
        for(Map.Entry<Character, Integer> entryset : map.entrySet()) {
            maxHeap.offer(entryset.getKey());
        }

        // 3. Build your answer by popping each element and appending them as much time they were in s.
        // O(nlog k) time
        StringBuilder ans = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            for(int i = 0; i < map.get(c); i++) {
                ans.append(c + "");
            }
        }

        return ans.toString();
    }

    private String approachTwo(String s) {
        /*  Approach: bucket Sort
            Time Complexity: O(n + n + n),
            Space Complexity: O(n + n) for hash map, bucket.
        */

        // 1. Build a HashMap to store characters and their respective frequencies in a hashmap
        // O(n) time
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 2. build Buckets to store frequency -> [chars] relation
        // O(n) time
        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for(Map.Entry<Character, Integer> entryset : map.entrySet()) {
            int occurence = entryset.getValue();
            char ch = entryset.getKey();
            if(bucket[occurence] == null) {
                bucket[occurence] = new ArrayList<>();
            }
            bucket[occurence].add(ch);
        }

        // 3. Build your answer by appending each element, from the bucket, as much time as they were in s.
        StringBuilder ans = new StringBuilder();
        for(int i = bucket.length - 1; i >= 0; i--) {
            if(bucket[i] != null) {
                for(char ch : bucket[i]) {
                    for(int j = 0; j < i; j++) {
                        ans.append(ch + "");
                    }
                }
            }
        }

        return ans.toString();
    }


    /**
     * There is a follow up, when same frequency we need to maintain the same sequence as the character show in the original string,
     * the solution is add a index as a secondary sort if the frequency is same, code is same as approachOne modified as below:
     */
    private String approachThree(String s) {
        /*  Approach: heap (Priority Queue)
            Time Complexity: O(n logk), k at max 52.
            Space Complexity: O(n + n)

            // Sorting on the basis of priority of length first and if equal then by their first occured index.
            // PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> (map.get(c2) == map.get(c1))? s.indexOf(c1) - s.indexOf(c2) : map.get(c2) - map.get(c1));
        */

        // 1. Build a HashMap to store characters and their respective frequencies in a hashmap
        // O(n) time
        HashMap<Character, int[]> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(!map.containsKey(c)) {
                map.put(c, new int[] {1, i});
            }
            else {
                int[] freqAndIndex = map.get(c);
                freqAndIndex[0]++;
                map.put(c, freqAndIndex);
            }
        }

        // 2. Build a PQ where prioritizing elements that are more frequent.
        // O(nlog k) in worst case when all unique char. k will be atmost 26 small + 26 capital so log 52 = 5.7
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> (map.get(c2)[0] == map.get(c1)[0])? map.get(c1)[1] - map.get(c2)[1] : map.get(c2)[0] - map.get(c1)[0]);
        for(Map.Entry<Character, int[]> entryset : map.entrySet()) {
            maxHeap.offer(entryset.getKey());
        }

        // 3. Build your answer by popping each element and appending them as much time they were in s.
        // O(nlog k) time
        StringBuilder ans = new StringBuilder();
        while(!maxHeap.isEmpty()) {
            char c = maxHeap.poll();
            for(int i = 0; i < map.get(c)[0]; i++) {
                ans.append(c + "");
            }
        }

        return ans.toString();

    }

}
