package LeetCode.heap;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/sort-characters-by-frequency/
 * Difficulty level : Medium
 */
public class problem451_SortCharactersByFrequency {
    private static class Entry {

        char key;
        int value;

        Entry(char key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public String frequencySort(String s) {
        // return approachOne(s);
        return approachTwo(s);
    }

    /**
     Time : N
     Space: N
     Algo : Add all the characters with its frequencies in map
     Create a bucket of size of length of string whose elements are of type lists
     (as multiple characters can have frequency)
     add character in bucket to the index of its frequency
     traverse buckey from the end as most frequency character will be the frist one from end
     */
    public String approachTwo(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character>[] bucket = new ArrayList[s.length() + 1];
        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (bucket[entry.getValue()] == null) {
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();

        for (int i = s.length(); i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c: bucket[i]) {
                    for (int k = 0; k < i; k++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     Time : N
     Space: constant (at max 26*2 + size of stringBuilder i.e. constant)
     Algo : First we count the frequencies of all characters and add them in priority queue
     sorted in descending order of their frequencies
     polling elements from pq and adding k characters in sb where k is freqquency of each character
     */
    public String approachOne(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Entry> pq = new PriorityQueue<>((Entry e1, Entry e2) -> e2.value - e1.value);

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.add(new Entry(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {

            int i = 0;
            Entry entry = pq.poll();

            while (i++ < entry.value) {
                sb.append(entry.key);
            }
        }
        return sb.toString();
    }
}
