/**
 * Author : Sradha Kedia
 * Link   : https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#
 * Difficulty level : Easy
 */

package GFG.SlidingWindow;

import java.util.*;

public class FirstNegativeInEveryWindowOfSizeK {

    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        long[] firstNegatives = new long[N - K + 1];
        int k = 0;

        List<Long> allNegatives = new ArrayList<>();
        for(int i = 0, j = 0; j < A.length; j++) {
            if(A[j] < 0) {
                allNegatives.add(A[j]);
            }

            if(j - i + 1 == K) {
                if(allNegatives.isEmpty()) {
                    firstNegatives[k++] = 0;
                } else {
                    firstNegatives[k++] = allNegatives.get(0);
                    if(A[i] == allNegatives.get(0)) {
                        allNegatives.remove(0);
                    }
                }
                i++;
            }
        }

        return firstNegatives;
    }
}
