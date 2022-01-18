/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/repeated-dna-sequences/
 * Difficulty level : Medium
 */

package leetcode.SlidingWindow;

import java.util.*;

public class Problem187_RepeatedDnaSequence {

    public static Map<Character, Integer> ACGT = Map.of('A', 0, 'C', 1, 'G', 2, 'T', 3);

    public List<String> findRepeatedDnaSequences(String s) {
        return approachThree(s);
    }

    private List<String> approachOne(String s) {
        List<String> repeatedDnaSequence = new ArrayList<>();

        Set<String> set = new HashSet<>();
        Set<String> tempSet = new HashSet<>();
        String dna = "";
        for(int i = 0, j = 0; j < s.length(); j++) {
            dna += s.charAt(j);
            if(j - i + 1 == 10) {
                if(set.contains(dna)) {
                    repeatedDnaSequence.add(dna);
                    set.remove(dna);
                }
                else {
                    if(!tempSet.contains(dna)) {
                        set.add(dna);
                    }
                    tempSet.add(dna);
                }
                dna = dna.substring(1);
                i++;
            }
        }

        return repeatedDnaSequence;
    }

    private List<String> approachTwo(String s) {
        Set<String> repeatedDnaSequence = new HashSet<>();
        Set<String> seenDnaSequence = new HashSet<>();
        String dna = "";

        for(int i = 0, j = 0; j < s.length(); j++) {
            dna += s.charAt(j);
            if(j - i + 1 == 10) {
                if(seenDnaSequence.contains(dna)) {
                    repeatedDnaSequence.add(dna);
                }
                else {
                    seenDnaSequence.add(dna);
                }
                dna = dna.substring(1);
                i++;
            }
        }

        return new ArrayList<>(repeatedDnaSequence);
    }

    private List<String> approachThree(String s) {
        // better than approachTwo, because here set is made of integer so space complexity is improved a lot.

        List<String> repeatedDnaSequence = new ArrayList<>();
        Set<Integer> seenDnaSequence = new HashSet<>();
        Set<Integer> tempSeenDnaSequence = new HashSet<>();

        int dna = 0;
        // mask is 11111111111100111111111111111111 (19,20th bit 0 to set msb of dna to 00)
        // int mask = ~(3 << 18);
        int mask = 0x3FFFF;

        for(int i = 0, j = 0; j < s.length(); j++) {
            // adding two lsb's depending on ACGT
            dna <<= 2;
            dna |= ACGT.get(s.charAt(j));
            if(j - i + 1 == 10) {
                if(seenDnaSequence.contains(dna)) {
                    repeatedDnaSequence.add(s.substring(i, j + 1));
                    seenDnaSequence.remove(dna);
                } else {
                    if(!tempSeenDnaSequence.contains(dna)) {
                        seenDnaSequence.add(dna);
                    }
                    tempSeenDnaSequence.add(dna);
                }
                // removing two msb's of dna
                dna &= mask;
                i++;
            }
        }

        return repeatedDnaSequence;
    }
}

/**
 * Approach 1, 2: Time Complexity: O(10n) where 10 is the dna length used to check existence in set in O(len(dna)) complexity,
 *                can cause extra computation time, use set of Integer instead.
 *                Space Complexity: O(2n)
 * Approach 3 : Time Complexity:O(n), Space Complexity:O(2n)
 */
