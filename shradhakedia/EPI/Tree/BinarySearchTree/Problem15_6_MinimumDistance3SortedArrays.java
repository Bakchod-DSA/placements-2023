/**
 * Author : Sradha Kedia
 * Page no.: 265, 266, 267 of Epi Java
 * Problem no.: 15.6
 * Difficulty level : Medium
 */

package EPI.Tree.BinarySearchTree;

import java.util.List;
import java.util.TreeSet;

public class Problem15_6_MinimumDistance3SortedArrays {

    public static int
    findMinDistanceSortedArrays(List<List<Integer>> sortedArrays) {
    /*  Approach: TreeSet (bst property, sorted order like in a heap but heap can't be applied here because we need
                  to get the elments from our data structure).
        Time complexity:  O(n logk), n = total no. of elements in k sorted array
        Space Complexity: O(k), size of tree set
        for k = 3, T.C. = O(n log3), S.C. = O(3).
    */

        int min = Integer.MAX_VALUE;

        TreeSet<ArrayEntry> triple = new TreeSet<>((a1, a2) -> (a1.element - a2.element) == 0? a1.row - a2.row : a1.element - a2.element);
        for(int i = 0; i < sortedArrays.size(); i++) {
            triple.add(new ArrayEntry(sortedArrays.get(i).get(0), i, 0));
        }

        while (triple.size() == sortedArrays.size()) {
            min = Math.min(min, triple.last().element - triple.first().element);
            ArrayEntry entry = triple.pollFirst();
            int row = entry.row;
            int col = entry.col;

            if(col < sortedArrays.get(row).size() - 1) {
                triple.add(new ArrayEntry(sortedArrays.get(row).get(col + 1), row, col + 1));
            }
        }

        return min;
    }

    public static class ArrayEntry {

        int element;
        int row;
        int col;

        ArrayEntry(int element, int row, int col) {
            this.element = element;
            this.row = row;
            this.col = col;
        }

    }
}
