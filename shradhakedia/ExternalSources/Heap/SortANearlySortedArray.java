package ExternalSources.Heap;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class SortANearlySortedArray {

    public static void main(String[] args) {

        int[] result = sort(new int[]{6, 5, 3, 2, 8, 10, 9}, 3);
        System.out.println(Arrays.toString(result));
    }

    private static int[] sort(int[] nums, int k) {

        int[] result = new int[nums.length];
        Queue<Integer> minHeap = new PriorityQueue<>();
        int index = 0;

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                result[index++] = minHeap.poll();
            }
        }

        while (!minHeap.isEmpty()) {
            result[index++] = minHeap.poll();
        }

        return result;
    }


}
