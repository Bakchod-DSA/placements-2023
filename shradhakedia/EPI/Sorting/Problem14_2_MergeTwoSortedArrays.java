/**
 * Author : Sradha Kedia
 * Page no.: 238 of Epi Java
 * Problem no.: 14.2
 * Difficulty level : Medium
 */
package EPI.Sorting;

import java.util.List;

public class Problem14_2_MergeTwoSortedArrays {
    public static void mergeTwoSortedArrays(List<Integer> A, int m,
                                            List<Integer> B, int n) {

        int first = m - 1, second = n - 1, k = m + n - 1;
        while(first >= 0 && second >= 0) {
            if(A.get(first) > B.get(second)) {
                A.set(k, A.get(first));
                first--;
            } else {
                A.set(k, B.get(second));
                second--;
            }
            k--;
        }
        while(second >= 0) {
            A.set(k--, B.get(second));
            second--;
        }
    }
}
