/**
 * Author : Sradha Kedia
 * Page no.: 236 of Epi Java
 * Problem no.: 14.1
 * Difficulty level : Medium
 */
package EPI.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem14_1_IntersectSortedArrays {
    public static List<Integer> intersectTwoSortedArrays(List<Integer> A,
                                                         List<Integer> B) {

        return approachOne(A, B);
//    return approachTwo(A, B);
    }

    private static List<Integer> approachOne(List<Integer> A, List<Integer> B) {
    /*  Approach: Two pointers
        Time Complexity: O(m + n)
        Space Complexity: O(1)
    */
        int m = A.size(), n = B.size();
        List<Integer> common = new ArrayList<>();
        for(int i = 0, j = 0; i < m && j < n;) {
            int first = A.get(i);
            int second = B.get(j);
            if(first == second && (i == 0 || !A.get(i).equals(A.get(i - 1)))) {
                // when equal add to answer and increase both the pointers
                common.add(A.get(i));
                i++;
                j++;
            } else if(first < second) {
                i++;
            } else {
                j++;
            }
        }
        return common;
    }

    private static List<Integer> approachTwo(List<Integer> A, List<Integer> B) {
    /*  Approach: Searching and Sorting
        Time Complexity: O(m * log n)
        Space Complexity: O(1)
    */
        List<Integer> common = new ArrayList<>();
        for(int i = 0; i < A.size(); i++) {
            if((i == 0 || !A.get(i).equals(A.get(i - 1))) && Collections.binarySearch(B, A.get(i)) >= 0) {
                common.add(A.get(i));
            }
        }
        return common;
    }
}
