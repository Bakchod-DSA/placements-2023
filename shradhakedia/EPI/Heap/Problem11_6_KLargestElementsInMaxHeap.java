package EPI.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem11_6_KLargestElementsInMaxHeap {

    public static List<Integer> kLargestInBinaryHeap(List<Integer> A, int k) {
        /* Time Complexity: O(k logk)
           Space Complexity: O(k)
        */

        Queue<int[]> maxHeap = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        maxHeap.add(new int[] {A.get(0), 0});

        List<Integer> result = new ArrayList<>();

        for(int i = 0; i < k; i++) {

            int[] max = maxHeap.poll();
            int val = max[0];
            int idx = max[1];

            result.add(val);

            int leftChildIdx = 2 * idx + 1;
            int rightChildIdx = 2 * idx + 2;
            if(leftChildIdx < A.size()) {
                maxHeap.add(new int[] {A.get(leftChildIdx), leftChildIdx});
            }
            if(rightChildIdx < A.size()) {
                maxHeap.add(new int[] {A.get(rightChildIdx), rightChildIdx});
            }

        }
        return result;
    }
}
