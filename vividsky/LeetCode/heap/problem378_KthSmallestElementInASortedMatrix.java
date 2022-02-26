package LeetCode.heap;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 * Difficulty level : Medium
 */
public class problem378_KthSmallestElementInASortedMatrix {

    public int kthSmallest(int[][] matrix, int k) {
        return approachThree(matrix, k);
    }

    /**
     BinarySearch
     Time : O(2N * 2 * 10^9) difference between smallest and largest element can be 2*10^9
     N + N to find elements less than or equal to mid
     Space: constant
     Algo : low = smallest element; high = largest element
     if no. of elements less than mid < k -> we need more elements hence will shift
     low = mid + 1;
     if no. of elements greater or equal to mid >= k -> it can be a valid result
     (As we need smallest mid(will surely be an element of array) such that elements less than or equal to mid = k)
     */
    public int approachThree(int[][] matrix, int k) {

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int low = matrix[0][0];
        int high = matrix[row][col];
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int numLessOrEqualToMid = findNumLessOrEqualToMid(matrix, mid);
            if (numLessOrEqualToMid < k) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }

    /**
     Linear searching in 2D matrix
     We will start from top right element and will keep compairing element to mid
     if ele <= mid -> all elements in that particlur row smaller thn ele will also be less than mid ->
     we will add col + 1 to final count and look for more element in next row
     if ele > mid -> we will decrease our column
     */
    private int findNumLessOrEqualToMid(int[][] matrix, int mid) {
        int count = 0;
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] <= mid) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }

    /**
     Heap
     Time : O(rows + k)
     Space: O(K)
     Algo : Add first element of each row to heap, (min heap)
     pop peek element from heap and add next element of same row
     pop k - 1 times and kth popped element will be our kth smallest element in sorted matrix
     */
    public int approachTwo(int[][] matrix, int k) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((pair1, pair2) -> pair1[0] - pair2[0]);

        for (int i = 0; i < matrix.length; i++) {
            int[] pair = new int[] {matrix[i][0], 0, i};
            pq.add(pair);
        }

        for (int i = 0; i < k - 1; i++) {
            int[] pair = pq.poll();
            int row = pair[2];
            int col = pair[1];
            if (col < matrix[row].length - 1) {
                int[] newPair = new int[] {matrix[row][col + 1], col + 1, row};
                pq.add(newPair);
            }
        }
        return pq.poll()[0];
    }

    /**
     Using Heap and Iterator, same as approachTwo
     */
    public int approachOne(int[][] matrix, int k) {
        List<Iterator<Integer>> subarrays = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                arr.add(matrix[i][j]);
            }
            subarrays.add(arr.iterator());
        }
        PriorityQueue<ArrayEntry> pq = new PriorityQueue<>((ArrayEntry e1, ArrayEntry e2) -> e1.value - e2.value);
        for (int i = 0; i < matrix.length; i++) {
            pq.add(new ArrayEntry(subarrays.get(i).next(), i));
        }

        for (int i = 0; i < k - 1; i++) {
            ArrayEntry entry = pq.poll();
            if (subarrays.get(entry.id).hasNext()) {
                pq.add(new ArrayEntry(subarrays.get(entry.id).next(), entry.id));
            }
        }
        return pq.poll().value;
    }

    private static class ArrayEntry {
        int value;
        int id;

        ArrayEntry(int value, int id) {
            this.value = value;
            this.id = id;
        }
    }
}
