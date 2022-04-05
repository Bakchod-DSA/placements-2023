/**
 * Author : Sradha Kedia
 * Page no.: 267, 268, 269 of Epi Java
 * Problem no.: 15.7
 * Difficulty level : Medium
 */

package EPI.Tree.BinarySearchTree;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;

public class Problem15_7_ABSqrt2 {

    public static List<Double> generateFirstKABSqrt2(int k) {
        // return approachOne(k);
        return approachTwo(k);
    }

    private static List<Double> approachOne(int k) {
    /*  Approach: TreeSet
        Time complexity: O(k logk)
        Space Complexity: O(k)
    */

        List<Double> result = new ArrayList<>();
        NavigableSet<ABSqrtTwo> candidates = new TreeSet<>();
        candidates.add(new ABSqrtTwo(0, 0));

        while (result.size() < k) {
            ABSqrtTwo smallestPair = candidates.pollFirst();
            result.add(smallestPair.val);
            candidates.add(new ABSqrtTwo(smallestPair.first + 1, smallestPair.second));
            candidates.add(new ABSqrtTwo(smallestPair.first, smallestPair.second + 1));
        }

        return result;
    }

    private static List<Double> approachTwo(int k) {
        int a = 0, b = 0;
        List<Double> result = new ArrayList<>();
        result.add(a + b * Math.sqrt(2));

        for(int i = 1; i < k; i++) {
            double first = result.get(a) + 1;
            double second = result.get(b) + Math.sqrt(2);
            System.out.println(result.get(a) + ", " + first);
            System.out.println(result.get(b) + ", " + second);
            if(Double.compare(first, second) == -1) {
                result.add(first);
                a++;
            } else if(Double.compare(first, second) == 1) {
                result.add(second);
                b++;
            } else {
                result.add(first);
                a++;
                b++;
            }
        }

        return result;
    }

    public static class ABSqrtTwo implements Comparable<ABSqrtTwo> {
        int first;
        int second;
        double val;

        ABSqrtTwo(int first, int second) {
            this.first = first;
            this.second = second;
            this.val = first + second * Math.sqrt(2);
        }

        @Override
        public int compareTo(ABSqrtTwo o) {
            return Double.compare(val, o.val);
        }

        @Override
        public String toString() {
            return "ABSqrtTwo{" +
                    "first=" + first +
                    ", second=" + second +
                    ", val=" + val +
                    '}';
        }
    }
}
