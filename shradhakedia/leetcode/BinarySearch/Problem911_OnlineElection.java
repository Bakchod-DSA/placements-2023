/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/online-election/
 * Difficulty level : Medium
 */
package leetcode.BinarySearch;

import java.util.*;

public class Problem911_OnlineElection {

    class TopVotedCandidate {


        Map<Integer, Integer> personToVoteCount;
        int[] leadingCandidate;
        int[] times;

        public TopVotedCandidate(int[] persons, int[] times) {
        /*  Approach: Precomputed Answer + Binary Search
            Time Complexity: O(n + (m * log n)), n for finding precomputed winners, m = no. of queries, and for each query
                             we run BS on precomputed winners.
            Space Complexity: O(n + n + n), n for map, n for precomputed winners, n for times.
        */

            personToVoteCount = new HashMap<>();
            leadingCandidate = new int[times.length];
            this.times = times;

            fillLeadingCandidate(persons, times);
            // System.out.println(Arrays.toString(leadingCandidate));
        }

        public int q(int t) {
            int infimum = lowerBound(times, t);
            if(infimum == -1) {
                // there was no vote cast till time t. hence, no winner yet.
                // Although, this case will not occur as q is always >= times[0].
                return -1;
            }
            return leadingCandidate[infimum];
        }

        private void fillLeadingCandidate(int[] persons, int[] times) {
            // T.C. O(n)
            leadingCandidate[0] = persons[0];
            personToVoteCount.put(persons[0], 1);

            for(int i = 1; i < times.length; i++) {
                personToVoteCount.put(persons[i], personToVoteCount.getOrDefault(persons[i], 0) + 1);
                int prevPerson = leadingCandidate[i - 1];
                int currPerson = persons[i];
                if(personToVoteCount.get(prevPerson) > personToVoteCount.get(currPerson)) {
                    leadingCandidate[i] = prevPerson;
                } else {
                    leadingCandidate[i] = currPerson;
                }
            }
        }


        private int lowerBound(int[] times, int t) {
            int low = 0, high = times.length - 1;
            while(low < high) {
                int mid = high - (high -low)/2;
                if(times[mid] > t) {
                    high = mid - 1;
                } else {
                    low = mid;
                }
            }

            if(high == 0 && times[0] > t) return -1;
            return high;
        }
    }
}