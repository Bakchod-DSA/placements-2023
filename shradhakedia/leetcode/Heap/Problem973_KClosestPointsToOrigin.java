/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/k-closest-points-to-origin/
 * Difficulty level: Medium
 */

package leetcode.Heap;

import java.util.*;

public class Problem973_KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {

        return approachOne(points, k);
        // return approachTwo(points, k);
        // return approachThree(points, k);
        // return approachFour(points, k);
    }

    private int[][] approachOne(int[][] points, int k) {
        /*  Approach: Sorting, Java uses Quick sort for Arrays.sort() for arrays of primitive which uses nlogn time and logn space.
                      and Time sort (hybrid of merge and insertion) for arrays of objects(int[]) which uses nlogn time and n space.
            Time complexity: O(nlog n).
            Space complexity: O(k).
        */

        Arrays.sort(points, (l1, l2) -> (l1[0] * l1[0]) + (l1[1] * l1[1]) -(l2[0] * l2[0]) - (l2[1] * l2[1]));
        return Arrays.copyOf(points, k);
    }

    private int[][] approachTwo(int[][] points, int k) {
        /*  Approach: Max Heap (Priority Queue)
            Time complexity: O(N⋅logk). Adding to/removing from the heap (or priority queue) only takes O(logk) time when the size
                             of the heap is capped at kk elements.
            Space complexity: O(k). The heap (or priority queue) will contain at most k elements.
        */

        Queue<int[]> maxHeap = new PriorityQueue<>(k, (l1, l2) -> (l2[0] * l2[0]) + (l2[1] * l2[1]) -(l1[0] * l1[0]) - (l1[1] * l1[1]));

        for(int[] point : points) {
            maxHeap.add(point);
            if(maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            ans[i] = maxHeap.poll();
        }

        return ans;
    }

    private int[][] approachThree(int[][] points, int k) {
        /* Approach : Quick Select on array elements based on their Eucilidean distance.
           Time complexity:  O(N). Similar to the earlier binary search solution, the QuickSelect solution has
                             a worst-case time complexity of O(N^2).if the worst pivot is chosen each time.
                             On average, however, it has a time complexity of O(N) because it halves (roughly)
                             the remaining elements needing to be processed at each iteration. This results in
                             N + N/2 + N/4 + N/8 + ... + N/N = 2N total processes, yielding an average time
                             complexity of O(N).
           Space complexity: O(1). The QuickSelect algorithm conducts the partial sort of points in place
                             with no recursion, so only constant extra space is required.
        */

        int kthIndex = quickSelect(points, k);

        return Arrays.copyOf(points, kthIndex + 1);
    }

    private int quickSelect(int[][] points, int k) {

        int low = 0;
        int high = points.length - 1;

        while(low <= high) {
            int pivotIndex = high;
            int newPivotIndex = findPivot(points, low, pivotIndex);

            if(newPivotIndex < k - 1) {
                low = newPivotIndex + 1;
            } else if(newPivotIndex == k - 1) {
                return newPivotIndex;
            } else {
                high = newPivotIndex - 1;
            }
        }

        return -1;
    }

    private int findPivot(int[][] points, int start, int pivotIndex) {

        int newPivotIndex = start;

        for(int i = start; i < pivotIndex; i++) {
            int pivotDis = squaredDistance(points[pivotIndex]);

            if(squaredDistance(points[i]) < pivotDis) {
                // swap newPivotIndex and i
                swap(points, i, newPivotIndex);

                newPivotIndex++;
            }
        }
        // swap newPivotIndex and oldPivot we chose
        swap(points, pivotIndex, newPivotIndex);

        return newPivotIndex;
    }

    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }

    private void swap(int[][] points, int i, int j) {

        int[] temp = points[j];
        points[j] = points[i];
        points[i] = temp;
    }

    private int[][] approachFour(int[][] points, int k) {
        /*  Approach: Binary Search
            Time Complexity: O(n + n * log(farthest distance))
            Space Complexity: O(n + k + n) n for distances, k for kClosest list, n for closer, farther
        */

        int[] distances = new int[points.length];
        List<Integer> remaining = new ArrayList<>();
        int low = 0;
        int high = 0;

        for(int i = 0; i < points.length; i++) {
            // Precompute the Euclidean distance for each point,
            // define the initial binary search range, low = 0, high = farthest dis. i.e max of distances
            // and create a reference list(remaining) of point indices to inform how many points are still remaining
            distances[i] = squaredDistance(points[i]);
            remaining.add(i);
            high = Math.max(high, distances[i]);
        }

        List<Integer> closest = binarySearch(distances, remaining, low, high, k);

        int[][] ans = new int[k][2];
        for(int i = 0; i < k; i++) {
            ans[i] = points[closest.get(i)];
        }

        return ans;
    }

    private List<Integer> binarySearch(int[] distances, List<Integer> remaining, int low, int high, int k) {
        /* Time Complexity: O(n), While this binary search variant has a worst-case time complexity of O(N^2), it has an average
                            time complexity of O(N)O(N). It achieves this by halving (on average) the remaining elements needing
                            to be processed at each iteration, which results in N + N/2 + N/4 + N/8 + ... + N/N = 2N total processes.
                            This yields an average time complexity of O(N).
           Space Complexity: O(n). An extra O(N) space is required for the arrays containing distances and reference
                             indices(remaining, closer, farther).
        */

        List<Integer> kClosest = new ArrayList<>();

        while(k > 0) {
            // continue till k closest points are not collected.
            int mid = low + (high - low)/2;
            List<List<Integer>> result = splitDistances(distances, remaining, mid);
            List<Integer> closer = result.get(0);
            List<Integer> farther = result.get(1);

            if(closer.size() > k) {
                // If more than k points are in the closer distances
                // then discard the farther points and continue
                remaining = closer;
                high = mid - 1;
            } else {
                // Add the closer points to the answer array and keep
                // searching the farther distances for the remaining points
                kClosest.addAll(closer);
                low = mid + 1;
                remaining = farther;
                k -= closer.size();
            }
        }

        return kClosest;
    }

    private List<List<Integer>> splitDistances(int[] distances, List<Integer> remaining, int mid) {
        /* Time Complexity: O(n)
           Space Complexity: O(n)
        */

        // Split the distances around the midpoint
        // and return them in separate lists
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> closer = new ArrayList<>();
        List<Integer> farther = new ArrayList<>();
        result.add(closer);
        result.add(farther);

        for(int point : remaining) {
            if(distances[point] <= mid) {
                closer.add(point);
            } else {
                farther.add(point);
            }
        }


        return result;
    }

}
