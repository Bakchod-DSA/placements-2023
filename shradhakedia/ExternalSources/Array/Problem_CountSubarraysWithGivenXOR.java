/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://www.codingninjas.com/codestudio/problems/1115652
 * Difficulty level: Medium
 */
package ExternalSources.Array;

import java.util.*;

public class Problem_CountSubarraysWithGivenXOR {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        // Write your code here.
        Map<Integer, Integer> prefixXorToFreq =  new HashMap<>();
        int c = 0;
        int prefixXor = 0;
        for(int i : arr) {
            prefixXor ^= i;
            if(prefixXor == x) {
                c++;
            }
            if(prefixXorToFreq.containsKey(prefixXor ^ x)) {
                c += prefixXorToFreq.get(prefixXor ^ x);
            }
            prefixXorToFreq.put(prefixXor, prefixXorToFreq.getOrDefault(prefixXor, 0) + 1);
        }
        return c;
    }
}
