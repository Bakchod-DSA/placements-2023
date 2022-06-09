/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/sequential-digits/
 * Difficulty level: Medium
 */
package leetcode.Strings;

import java.util.*;

public class Problem1291_SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        // 1 2 3 4 5 6 7 8 9
        String lowS = Integer.toString(low);
        String highS = Integer.toString(high);
        int lenLow = lowS.length();
        int lenHigh = highS.length();
        String digits = "123456789";

        List<Integer> sequentialDigits = new ArrayList<>();
        for(int i = lenLow; i <= lenHigh; i++) {
            for(int j = 0; j < 9 && (j + i) <= 9; j++) {
                int num = Integer.parseInt(digits.substring(j, j + i));
                if(num >= low && num <= high) {
                    sequentialDigits.add(num);
                } else if(num > high) {
                    break;
                }
            }
        }

        return sequentialDigits;
    }
}
