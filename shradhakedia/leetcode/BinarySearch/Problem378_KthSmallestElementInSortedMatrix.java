/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * Difficulty level : Medium
 * Discuss: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/discuss/1322101/C%2B%2BJavaPython-MaxHeap-MinHeap-Binary-Search-Picture-Explain-Clean-and-Concise
 */

package leetcode.BinarySearch;

import java.util.*;

public class Problem378_KthSmallestElementInSortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {

        // return approachOne(matrix, k);
        // return approachTwo(matrix, k);
        return approachThree(matrix, k);
        // return approachFour(matrix, k);

    }

    private int approachOne(int[][] matrix, int k) {
        /*  Approach: Priority Queue(min Heap)
            Time Complexity: O((mn) * logk))
            Space Complexity: O(k)
            Intuition: kth smallest = length - k + 1 largest element, using the concept we can find n - k + 1
                        largest element with min Heap, keeping only elements we ensure that in the end heap
                        has k elements in which k - 1 are larger than the root, so root becomes the kth
                        largest, we start by adding k elements, then as size > k, we remove one smaller
                        element, the kth element being at kth position, as we keep on deleting smaller n - k
                        elements, k - 1 larger elements are placed at last and kth kept on moving towards
                        heap.

        */

        k = (matrix.length * matrix[0].length) - k + 1;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int[] row : matrix) {
            for(int ele: row) {
                minHeap.offer(ele);
                if(minHeap.size() > k) {
                    minHeap.poll();
                }
            }
        }

        return minHeap.poll();

    }

    private int approachTwo(int[][] matrix, int k) {
        /*  Approach: Priority Queue(max Heap)
            Time Complexity: O((mn) * logk))
            Space Complexity: O(k)
            Intuition: Opposite of approach 1.
        */

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for(int[] row : matrix) {
            for(int ele: row) {
                maxHeap.offer(ele);
                if(maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }

        return maxHeap.poll();

    }

    private int approachThree(int[][] matrix, int k) {
        /*  Approach:   Priority Queue(min Heap)
            Time Complexity:    O(min(rows,k)log(min(rows, k) + klog(min(rows, k)) )
            Space Complexity:   O(min(rows,k))
            Intuition:  Add all the row's first element. In min heap all the elements will be sorted.
                        now, when we run loop k times and pop root(current smallest) element. and add the
                        same row element but column + 1. it will again be sorted accordingly. and like this
                        as we reach kth iteration, the kth element is popped and we return that ans.
        */

        int m = matrix.length;
        int n = matrix[0].length;
        int kth = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((o1,o2) -> o1[0] - o2[0]);
        for(int r = 0; r < Math.min(m, k); r++) {
            minHeap.offer(new int[] {matrix[r][0], r, 0});
        }

        for(int i = 1; i <= k; i++) {

            int[] ans = minHeap.poll();
            int r = ans[1];
            int c = ans[2];

            if(c + 1 < n) {
                minHeap.offer(new int[] {matrix[r][c + 1], r, c + 1});
            }

            kth = ans[0];
        }

        return kth;
    }

    private int approachFour(int[][] matrix, int k) {
        /*  Approach: Binary Search
            Time Complexity: O((m + n) * logD)), where D = max(last) element - min(first) element.
            Space Complexity: O(1)
            Intution:   simple binary searching; take the min, max element. find the mid and then
                        the nos. in the matrix that are smaller than/equal to this mid, let us call it count.
                        now, for an element to be kth smallest we need exactly k elements smaller and equal
                        to it. so, if count is less than k, means we need more elements that are smaller
                        to mid. therefore, we can shift towards right by doing low = mid + 1 to increase
                        the count.
                        if, count > k we want to lower this count, as there are more than k elements
                        that are smaller than/equal mid but we need to include mid because there can be
                        a duplicate of this mid in matrix which is the answer so we can't risk to remove it.
                        Test case:  [[1,1,3,8,13],[4,4,4,8,18],[9,14,18,19,20],[14,19,23,25,25],
                                    [18,21,26,28,29]]
                                    k = 13.
                        if count == k means we have got a mid such that there are k elements smaller than/
                        equal to it. but, we cannot guarantee that this mid is an element of our matrix,
                        maybe there is a value in matrix that is smaller than mid and also has k elements
                        smaller than/equal to it. so we can safely apply binary search again, to reduce the
                        space from right, but saving this mid also as this can be element of the matrix.
                        and we keep on doing this, till low < high. as soon as low == high we come out of
                        loop and get the answer.
        */

        int m = matrix.length;
        int n = matrix[0].length;

        int low = matrix[0][0], high = matrix[m - 1][n - 1];
        while(low < high) {
            int mid = low + ((high - low) >> 1);

            int count = countLessThanEqualElements(matrix, mid);
            if(count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return high;
    }

    private int countLessThanEqualElements(int[][] matrix, int target) {
        /*  Time Complexity: O(m + n)
            Space Complexity: O(1)
            Intuition:  use two pointers r = 0 denotes first row, c = n - 1 denotes last column.
                        check if matrix[r][c] > target, decrement c, elese if less than/equal add c + 1 to                           the result, continue for all the rows.
        */

        int m = matrix.length;
        int n = matrix[0].length;

        int count = 0;
        int c = n - 1;
        for(int r = 0; r < m; r++) {
            while(c >= 0 && matrix[r][c] > target) { //greater just keep on decreasing c.
                c--;
            }
            count += (c + 1); // if matrix[r][c] <= target, add the no. of col. elements to result.
        }

        return count;
    }
}