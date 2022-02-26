package EPI.Heap;

import java.util.*;

public class Problem11_5_OnlineMedian {

    public static List<Double> onlineMedianData(Iterator<Integer> sequence) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        List<Double> result = new ArrayList<>();

        while(sequence.hasNext()) {

            int k = sequence.next();
            if (minHeap.isEmpty()) {
                minHeap.add(k);
            } else if(minHeap.peek() > k){
                maxHeap.add(k);
            } else {
                minHeap.add(k);
            }

            if(minHeap.size() > maxHeap.size() + 1) {
                maxHeap.add(minHeap.poll());
            } else if(maxHeap.size() > minHeap.size()){
                minHeap.add(maxHeap.poll());
            }

            if(minHeap.size() == maxHeap.size() + 1) {
                result.add((double) minHeap.peek());
            } else {
                result.add((minHeap.peek() + maxHeap.peek()) / 2.0);
            }
        }
        return result;
    }

}
