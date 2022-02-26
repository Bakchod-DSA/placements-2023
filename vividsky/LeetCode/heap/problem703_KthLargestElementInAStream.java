package LeetCode.heap;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/kth-largest-element-in-a-stream/
 * Difficulty level : Easy
 */
public class problem703_KthLargestElementInAStream {

    PriorityQueue<Integer> pq;
    int k;

    /**
     Time : O(N) where  N = length of stream
     Space: O(K) size of priorityQueue
     Algo : Add first k elements in increasing order, compare next elements to the peek of the array,
     if element is smaller than peek -> poll() smaller element and add curr element
     */
    public KthLargest(int k, int[] nums) {
        this.k = k;
        pq = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                pq.add(nums[i]);
            } else if (nums[i] > pq.peek()) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (pq.size() >= k && val > pq.peek()) {
            pq.poll();
        }
        if (pq.size() < k) {
            pq.add(val);
        }
        return pq.peek();
    }
}
