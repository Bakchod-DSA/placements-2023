/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/maximum-frequency-stack/
 * Difficulty level: Hard
 */

package leetcode.HashTable;

import java.util.*;

public class Problem895_MaximumFrequencyStack {

    class FreqStack {

        Map<Integer, Integer> freq;
        Map<Integer, Stack<Integer>> group;
        int maxfreq;

        public FreqStack() {
            freq = new HashMap<>();
            group = new HashMap<>();
            maxfreq = 0;
        }

        public void push(int val) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);

            int f = freq.get(val);
            maxfreq = Math.max(f, maxfreq);

            // if(!group.containsKey(f)) {
            //     Stack<Integer> stack = new Stack<>();
            //     stack.push(val);
            //     group.put(f, stack);
            // } else {
            //     Stack<Integer> stack = group.get(f);
            //     stack.push(val);
            //     group.put(f, stack);
            // }

            // the below line works the same as above if else
            group.computeIfAbsent(f, z-> new Stack()).push(val);

        }

        public int pop() {
            int x = group.get(maxfreq).pop();
            freq.put(x, freq.get(x) - 1);
            if(group.get(maxfreq).size() == 0) {
                maxfreq--;
            }

            return x;
        }

    }

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */

}
