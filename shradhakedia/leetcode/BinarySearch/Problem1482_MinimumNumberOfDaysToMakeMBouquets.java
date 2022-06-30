/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * Difficulty level: Medium
 */
package leetcode.BinarySearch;

public class Problem1482_MinimumNumberOfDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m * k > n) {
            return -1;
        }

        int minDaysToMakeBouquet = binarySearch(bloomDay, m, k);
        return minDaysToMakeBouquet;
    }


    private int binarySearch(int[] bloomDay, int m, int k) {
        int low = 1;
        int high = findMax(bloomDay);
        while(low < high) {
            int mid = low + (high - low)/2;
            int expectedBouquets = findExpectedBouqetsMadeForGivenBloomDay(bloomDay, mid, k);
            // System.out.println(low + " " + mid + " " + high + " " + expectedBouquets);
            if(expectedBouquets < m) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

    private int findMax(int[] bloomDay) {
        int max = Integer.MIN_VALUE;
        for(int d : bloomDay) {
            max = Math.max(max, d);
        }

        return max;
    }

    private int findExpectedBouqetsMadeForGivenBloomDay(int[] bloomDay, int day, int k) {
        int expectedBouquets = 0, flowers = 0;
        for (int j = 0; j < bloomDay.length; j++) {
            if (bloomDay[j] > day) {
                flowers = 0;
            } else if (++flowers >= k) {
                expectedBouquets++;
                flowers = 0;
            }
        }

        return expectedBouquets;
    }
}
