package EPI.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class problem11_1_SortedArraysMerge {

    /**
     * peek is an primitive array with three elements: 1 -> element, 2 -> index of that element, 3 -> array to which that element belong
     * e.g. sortedArrays = [[3,5,7], [0,6], [0,6,28]]
     * element in pq will be [0, 0, 1], [0, 0, 2], [3, 0, 0], [6, 1, 1], [6, 1, 2], [5, 1, 0], [7, 2, 0], [28, 2, 2]
     * First we add all the first element of each array in pq, and then while our heap is not empty,
     * we keep polling peek element of heap and adding next element based on element popped (will add next element of that particular array if exist)
     */
    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        // comparing the elements
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt((int[] a) -> a[0]));
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < sortedArrays.size(); i++) {
            pq.add(new int[] {sortedArrays.get(i).get(0), 0, i});
        }
        while (!pq.isEmpty()) {
            int[] peek = pq.poll();
            result.add(peek[0]);
            if (peek[1] < sortedArrays.get(peek[2]).size()) {
                pq.add(new int[] {sortedArrays.get(peek[2]).get(peek[1] + 1), peek[1] + 1, peek[2]});
            }
        }
        return result;
    }
}
