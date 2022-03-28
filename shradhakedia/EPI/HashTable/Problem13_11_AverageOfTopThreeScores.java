/**
 * Author : Sradha Kedia
 * Page no.: 227-228 of Epi Java
 * Problem no.: 13.11
 * Difficulty level : Medium
 */

package EPI.HashTable;

import java.util.*;

public class Problem13_11_AverageOfTopThreeScores {

    public static void main(String[] args) {

        List<Object> nsData = new ArrayList<>();
        nsData.add("S");
        nsData.add(100);
        nsData.add("S");
        nsData.add(97);
        nsData.add("A");
        nsData.add(60);
        nsData.add("A");
        nsData.add(100);
        nsData.add("A");
        nsData.add(100);
        nsData.add("A");
        nsData.add(100);
        nsData.add("S");
        nsData.add(60);
        nsData.add("S");
        nsData.add(97);

        String topStudent = findStudentWithHighestBestOfThreeScores(nsData.iterator());
        System.out.println(topStudent);

    }

    public static String findStudentWithHighestBestOfThreeScores(
            Iterator<Object> nameScoreData) {
        /*  Approach : HashTable + PriorityQueue
            Time Complexity: O(n), n = nameScoreData.size()
            Space Complexity: O(m), m = map.size()
        */

        Map<String, PriorityQueue<Integer>> studentScores = new HashMap<>();
        while(nameScoreData.hasNext()) {

            String name = (String) nameScoreData.next();
            int score = (int) nameScoreData.next();
            PriorityQueue<Integer> minHeap;

            studentScores.computeIfAbsent(name, z -> new PriorityQueue<>( (a, b) -> b - a)).add(score);
            minHeap = studentScores.get(name);
            if(minHeap.size() > 3) {
                minHeap.poll();
                studentScores.put(name, minHeap);
            }
        }

        String topStudent = null;
        int maxSumScore = Integer.MIN_VALUE;
        for(Map.Entry<String, PriorityQueue<Integer>> entrySet : studentScores.entrySet()) {

            PriorityQueue<Integer> pq = entrySet.getValue();
            if(pq.size() == 3) {
                int sum = 0;
                while(!pq.isEmpty()) {
                    sum += pq.poll();
                }
                if(maxSumScore < sum) {
                    maxSumScore = sum;
                    topStudent = entrySet.getKey();
                }
            }
        }

        return topStudent;
    }

}
