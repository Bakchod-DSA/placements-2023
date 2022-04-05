package EPI.Tree.BinarySearchTree;

import java.util.*;

public class Problem15_8_MostVisitedPagesProblem {

    public static void main(String[] args) {
        List<Character> pages = new ArrayList<>(Arrays.asList('g', 'a', 't', 't', 'a', 'a', 'a', 'g', 't', 'c', 't', 'a', 't'));
        // k <= no. of unique elements in pages.
        System.out.println(findKMostVisitedPages(pages, 4));
    }
    public static List<Character> findKMostVisitedPages(List<Character> pages, int k) {
        List<Character> result = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : pages) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        Queue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((e1, e2) -> e2.getValue() - e1.getValue());
        maxHeap.addAll(map.entrySet());

        while(result.size() < k) {
            result.add(maxHeap.poll().getKey());
        }

        return result;
    }
}
