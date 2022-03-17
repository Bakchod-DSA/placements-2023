package LeetCode.heap;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/top-k-frequent-words/
 * Difficulty level : Medium
 */
public class problem692_TopKFrequentWords {

    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word: words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.getValue() != e2.getValue()) {
                return e2.getValue() - e1.getValue();
            } else {
                return e1.getKey().compareTo(e2.getKey());
            }
        });

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            pq.add(entry);
        }



        /**
         Here we will be taking n length Heap, and the elements stored in heap are in descending order,
         i.e. most frequent and lexicographically smaller elements will be on peek
         We can not take k size heap, as for this, we need heap with elements sorted in ascending order so that we
         can poll() least frequent or lexicographically larger ekements
         eithert it will result in more time complexity (heap of size() k where we keep adying elements at index 0)
         or extra space (either tw heaps or a stack in which we store elements and thn add those elements in arrayList)
         */

//          for (Map.Entry<String, Integer> entry: map.entrySet()) {
//             System.out.println(pq.size() + " " + k + " " + entry.getKey());
//             if (pq.size() < k) {
//                 pq.add(entry);
//             } else if (pq.peek().getValue() < entry.getValue()) {
//                 System.out.println(pq.peek().getValue() + " " + pq.peek().getKey());
//                 pq.poll();
//                 pq.add(entry);
//             }
//             System.out.println(pq);

//         }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Map.Entry<String, Integer> entry = pq.poll();
            result.add(entry.getKey());
        }
        return result;
    }
}
