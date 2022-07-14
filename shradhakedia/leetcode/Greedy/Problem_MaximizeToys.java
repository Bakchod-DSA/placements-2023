// https://practice.geeksforgeeks.org/problems/maximize-toys0331/1/?category
package leetcode.Greedy;

import java.util.Arrays;

public class Problem_MaximizeToys {
    static int toyCount(int N, int K, int arr[])
    {
        Arrays.sort(arr);

        int numOfToys = 0;
        for(int a : arr) {
            if(K >= a) {
                numOfToys++;
                K -= a;
            } else {
                break;
            }
        }

        return numOfToys;
    }
}
