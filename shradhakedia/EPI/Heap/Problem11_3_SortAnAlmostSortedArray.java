package EPI.Heap;

import java.util.*;

public class Problem11_3_SortAnAlmostSortedArray {

    public static List<Integer> sortApproximatelySortedData(Iterator<Integer> sequence, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> minHeap = new PriorityQueue<>();

        while (sequence.hasNext()) {
            int num = sequence.next();
            minHeap.add(num);
            if (minHeap.size() > k) {
                result.add(minHeap.poll());
            }
        }

        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;
    }

}
