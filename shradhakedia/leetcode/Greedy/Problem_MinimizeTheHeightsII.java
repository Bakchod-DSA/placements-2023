// https://practice.geeksforgeeks.org/problems/minimize-the-heights3351/1/?category
package leetcode.Greedy;

import java.util.Arrays;

public class Problem_MinimizeTheHeightsII {
    int getMinDiff(int[] arr, int n, int k) {
        Arrays.sort(arr);

        int partition = 1, max = 0, min = 0, mini = arr[n - 1] - arr[0];
        while(partition < n) {

            min = Math.min(arr[0] + k, arr[partition] - k);
            max = Math.max(arr[partition - 1] + k, arr[n - 1] - k);

            if(min < 0) {
                partition++;
                continue;
            }
            mini = Math.min(mini, max - min);
            partition++;
        }

        return mini;
    }
}
