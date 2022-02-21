/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * Difficulty level: Medium
 */

package leetcode.Heap;

import java.util.*;

public class Problem373__KPairsWithSmallestSums__ {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        return approachTwo(nums1, nums2, k);
    }

    private List<List<Integer>> approachOne(int[] nums1, int[] nums2, int k) {
        /*  Approach: Brute Force + Heap (Priority Queue) gives TLE
            Time Complexity: O(mn log k)
            Space Complexity: O(k)
        */

        Queue<List<Integer>> maxHeap = new PriorityQueue<>(k, (l1, l2) -> (l2.get(0) + l2.get(1)) - l1.get(0) - l1.get(1));

        for (int value : nums1) {
            List<Integer> pair = new ArrayList<>();
            pair.add(value);

            for (int i : nums2) {
                pair.add(i);

                maxHeap.add(new ArrayList<>(pair));
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }

                pair.remove(pair.size() - 1);

            }
        }

        return new ArrayList<>(maxHeap);
    }


    private List<List<Integer>> approachTwo(int[] nums1, int[] nums2, int k) {
        /*  Approach: Heap (Priority Queue)
            Time Complexity:  O( min(m,k) * log(min(m, k) + k * log(min(rows, k)) ), m = nums1.length;
            Space Complexity: O(min(m, k))
            Intuition: think these pairs as a matrix, for eg: [1,7,11], [2,4,6]

                 2      4       6
             1  1, 2   1, 4    1, 6
             7  7, 2   7, 4    7, 6
            11  11,2   11,4    11,6

            now, we add min(k , nums1.length) elements in heap prioritizing their sum, i.e. we add first col entries.
            we know our heap has the first min pair we poll it add to our ans and then push the next element of that row, if one
            exits. i.e. add (1,2),(7,2),(11,2) initially now (1, 2) is smallest we polled then added (1, 4) because next min pair can             be here at this location. so we add it. We do this k times.
        */

        Queue<List<Integer>> minHeap = new PriorityQueue<>(k, (l1, l2) -> (l1.get(0) + l1.get(1)) - l2.get(0) - l2.get(1));

        for(int i = 0; i < nums1.length && minHeap.size() < k; i++) {

            List<Integer> pair = new ArrayList<>();
            pair.add(nums1[i]);
            pair.add(nums2[0]);
            pair.add(i);
            pair.add(0);

            minHeap.add(new ArrayList<>(pair));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < k && !minHeap.isEmpty(); i++) {

            List<Integer> temp = minHeap.poll();
            ans.add(new ArrayList<>(Arrays.asList(temp.get(0), temp.get(1))));


            int r = temp.get(2);
            int c = temp.get(3);
            if(c + 1 < nums2.length) {

                List<Integer> next = new ArrayList<>();
                next.add(nums1[r]);
                next.add(nums2[c + 1]);
                next.add(r);
                next.add(c + 1);

                minHeap.add(next);
            }

        }

        return ans;
    }

}
