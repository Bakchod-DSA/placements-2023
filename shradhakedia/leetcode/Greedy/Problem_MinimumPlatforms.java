// https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1
package leetcode.Greedy;

import java.util.*;

public class Problem_MinimumPlatforms {
    static int findPlatform(int arr[], int dep[], int n)
    {
        Train[] trains = new Train[n];
        for(int i = 0; i < n; i++) {
            trains[i] = new Train();
            trains[i].arr = arr[i];
            trains[i].dep = dep[i];
        }

        Arrays.sort(trains, (t1, t2) -> t1.arr - t2.arr);

        Queue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(trains[0].dep);

        int numPlatformNeeded = 1;
        for(int i = 1; i < n; i++) {
            if(trains[i].arr > minHeap.peek()) {
                minHeap.remove();
            } else {
                numPlatformNeeded++;
            }
            minHeap.add(trains[i].dep);
        }

        return numPlatformNeeded;
    }

    static class Train {
        int arr;
        int dep;
        Train() {}
    }
}
