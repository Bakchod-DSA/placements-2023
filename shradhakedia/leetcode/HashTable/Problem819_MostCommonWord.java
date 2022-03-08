/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/most-common-word/
 * Difficulty level: Easy
 */

package leetcode.HashTable;

import java.util.*;

public class Problem819_MostCommonWord {

    public String mostCommonWord(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase();
        Set<String> bannedArray = new HashSet<>(Arrays.asList(banned));

        return approachOne(paragraph, bannedArray);
    }

    private String approachOne(String paragraph, Set<String> bannedArray) {
        /*  Approach: Hash Table
            Time Complexity:  O(n + m),
                              n be the number of characters in the input string and m be the number of characters in the
                              banned list. Also, in worst case paragraphArray can have n/2 size like paragraph = "a z x b c g
                              n h o.." thus iterating this array would take O(n/2) or O(n) time.
            Space Complexity: O(n + m),
                              We built a hashmap to count the frequency of each unique word, whose space would be of O(N).
                              Similarly, we built a set out of the banned word list, which would consume additional O(M)                                     space. Therefore, the overall space complexity of the algorithm is O(N+M).

        */

        String[] paragraphArray = paragraph.split("[!?',;. ]+");
        Map<String, Integer> map = new HashMap<>();
        for(String s : paragraphArray) {
            if(s != "") {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        int maxCount = Integer.MIN_VALUE;
        String ans = "";
        for(String s : paragraphArray) {
            if(s != "" && map.get(s) > maxCount && !bannedArray.contains(s)) {
                maxCount = map.get(s);
                ans = s;
            }
        }

        return ans;
    }

}
