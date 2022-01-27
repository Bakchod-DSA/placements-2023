/**
 * Author : Sradha Kedia
 * Page no.: 191, 192 of Epi Java
 * Problem no.: 12.2 variants
 * Difficulty level : Medium
 */

package EPI.BinarySearch;

import java.util.*;

public class Problem12_2_SearchEntryEqualToIndex {
    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>(Arrays.asList(1,2,5,6));
        System.out.println(variantOne(A, 0, A.size() - 1));
    }

    private static List<Integer> variantOne(List<Integer> A, int low, int high) {
        // variant 1: return all the elements equal to their index, array is sorted and has distinct elements.
        // Time Complexity: O(n), Space Complexity: O(1)

        if(low > high) {
            return new ArrayList<>();
        }

        List<Integer> tempList = new ArrayList<>();
        int midIndex = low + ((high - low) >> 1);
        int midValue = A.get(midIndex);
        if(midIndex == midValue) {
            tempList.add(midIndex);
            tempList.addAll(variantOne(A, low, midIndex - 1));
            tempList.addAll(variantOne(A, midIndex + 1, high));
        }
        else if(midIndex < midValue) {
            tempList.addAll(variantOne(A, low, midIndex - 1));
        } else {
            tempList.addAll(variantOne(A, midIndex + 1, high));
        }

        return tempList;
    }

    private static int variantTwo(List<Integer> A, int low, int high)  {
        // variant 2: return an element equal to its index, array is sorted and may have duplicate elements.
        // Time Complexity: O(n), Space Complexity: O(1)

        if(low > high) {
            return -1;
        }

        int midIndex = low + ((high - low) >> 1);
        int midValue = A.get(midIndex);

        if(midIndex == midValue) {
            return midIndex;
        }
        int left = variantTwo(A, low, Math.min(midValue, midIndex - 1));
        return (left >= 0) ? left: variantTwo(A, Math.max(midValue, midIndex + 1), high);
    }
}
