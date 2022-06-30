/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/successful-pairs-of-spells-and-potions/
 * Difficulty level : Medium
 */
package leetcode.BinarySearch;

import java.util.Arrays;

public class Problem2300_SuccessFullPairsOfSpellAndPotions {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);

        int n = spells.length;
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            int supremum = upperBound(potions, spells[i], success);
            res[i] = (supremum == -1)? 0 : potions.length - supremum;
        }

        return res;
    }

    private int upperBound(int[] potions, int spell, long success) {
        int low = 0, high = potions.length - 1;

        while(low < high) {
            int mid = low + (high - low)/2;
            long prod = (long) potions[mid] * spell;
            if(prod < success) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        if(low == potions.length - 1 && (long) potions[low] * spell < success) return -1;
        else return high;
    }
}
