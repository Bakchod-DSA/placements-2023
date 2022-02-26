package EPI.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem11_1_MergeSortedFiles {

    public static List<Integer> MergeKSortedArrays(List<List<Integer>> sortedArrays) {

        Queue<int[]> minHeap = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < sortedArrays.size(); i++) {
            int[] value = new int[] {sortedArrays.get(i).get(0), i, 0};
            minHeap.add(value);
        }

        while (!minHeap.isEmpty()) {
            int[] value = minHeap.poll();
            result.add(value[0]);
            int r = value[1];
            int c = value[2];
            if(c + 1 < sortedArrays.get(r).size()) {
                int[] next = new int[] {sortedArrays.get(r).get(c + 1), r, c + 1};
                minHeap.add(next);
            }
        }

        return result;
    }
}
