/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1#
 * Difficulty level: Medium
 */
package ExternalSources.StackAndQueue;

import java.util.*;

public class Problem_TheCelebrityProblem {
    int celebrity(int[][] M, int n)
    {
        // code here
        return approachOne(M, n);
    }

    int approachOne(int[][] M, int n) {
        /*  Approach: Stack
            Time Complexity: O(n)
            Space Complexity: O(n)
        */
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            stack.addFirst(i);
        }

        while(stack.size() > 1) {
            int a = stack.removeFirst();
            int b = stack.removeFirst();
            if(M[a][b] == 1) {
                // a knows b, cannot be a celebrity for sure.
                stack.addFirst(b);
            } else {
                stack.addFirst(a);
            }
        }

        int celebCandidate = stack.peekFirst();
        for(int i = 0; i < n && i != celebCandidate; i++) {
            if(M[i][celebCandidate] == 0) return -1;
        }

        for(int i = 0; i < n; i++) {
            if(M[celebCandidate][i] == 1) return -1;
        }
        return celebCandidate;
    }
}
