/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/bulls-and-cows/
 * Difficulty level: Medium
 */

package leetcode.HashTable;

public class Problem299_BullsAndCows {

    public String getHint(String secret, String guess) {
        return approachOne(secret, guess);
    }

    private String approachOne(String secret, String guess) {
        /*  Approach: Hash Table
            Time Complexity: O(n)
            Space Complexity: O(10)
        */

        int[] map = new int[10];
        int bulls = 0, cows = 0;

        for(int i = 0; i < secret.length(); i++) {

            int sDigit = secret.charAt(i) - '0';
            int gDigit = guess.charAt(i) - '0';
            if(sDigit == gDigit) {
                bulls++;
            } else {
                if(map[sDigit] < 0) cows++;
                if(map[gDigit] > 0) cows++;
                map[sDigit]++;
                map[gDigit]--;
            }
        }

        return bulls + "A" + cows + "B";
    }

}
