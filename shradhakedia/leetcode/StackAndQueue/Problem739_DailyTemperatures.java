/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/daily-temperatures/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.*;

public class Problem739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        return approachOne(temperatures);
    }

    private int[] approachOne(int[] temperatures) {
        /*  Approach: brute force
            Time Complexity: O(n ^ 2)
            Space Complexity: O(1)
        */
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(temperatures[j] > temperatures[i]) {
                    ans[i] = j - i;
                    break;
                }
            }
        }
        return ans;
    }

    private int[] approachTwo(int[] temperatures) {
        /*  Approach: Monotonic Stack
            Time Complexity: O(n)
            Space Complexity: O(n)
        */
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> decStack = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            // Pop until the current day's temperature is not
            // warmer than the temperature at the top of the stack
            while(!decStack.isEmpty() && temperatures[decStack.peekFirst()] < temperatures[i]) {
                ans[decStack.peekFirst()] = i - decStack.removeFirst();
            }
            decStack.addFirst(i);
        }
        return ans;
    }

    private int[] approachThree(int[] temperatures) {
        /*  Approach: Array, Optimized space
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        int n = temperatures.length;
        int[] ans = new int[n];
        for(int i = n - 1; i >=  0; i--) {
            if(temperatures[i + 1] > temperatures[i]) {
                ans[i] = 1;
            } else {
                int days = i + 1;
                while(ans[days] != 0) {
                    // Use information from answer to search for the next warmer day
                    if(temperatures[days] > temperatures[i]) {
                        ans[i] = days - i;
                        break;
                    } else {
                        days += temperatures[days];
                    }
                }
                if(temperatures[days] > temperatures[i]) {
                    ans[i] = days - i;
                }
            }
        }
        return ans;
    }}
