/**
 * Author : Sradha Kedia
 * Page no.: 230-231 of Epi Java
 * Problem no.: 13.13
 * Difficulty level : Medium
 */

package EPI.HashTable;

import java.util.HashSet;
import java.util.Set;

public class Problem13_13_CollatzConjecture {

    public static boolean testCollatzConjecture(int n) {

        // Stores odd numbers already tested to converge to 1
        Set<Long> verifiedNumbers = new HashSet<>();

        // Starts from 3, since hypothesis holds trivially for 1 and 2
        for(int i = 3; i <= n; i += 2) {
            Set<Long> sequence = new HashSet<>();
            long testI = (long) i;

            while(testI >= i) {
                if(sequence.contains(testI)) {
                    // infinite loop
                    return false;
                } else {
                    sequence.add(testI);
                }

                if(verifiedNumbers.contains(testI)) {
                    // it converges to 1 as the testI is already verified.
                    break;
                } else {
                    verifiedNumbers.add(testI);
                }

                if((testI % 2) != 0) {
                    testI = testI * 3 + 1;
                    if(testI <= 0) throw new ArithmeticException("Collatz sequence overflow for " + i);
                } else {
                    testI /= 2;
                }
            }
        }
        return true;
    }

}
