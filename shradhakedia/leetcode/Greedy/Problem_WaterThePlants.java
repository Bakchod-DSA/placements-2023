// https://practice.geeksforgeeks.org/problems/410d51d667ab93f2219b15126f001f32e8bb029e/1/?category#
package leetcode.Greedy;

import java.util.*;

public class Problem_WaterThePlants {
    int min_sprinklers(int gallery[], int n)
    {
        ArrayList<Range> range = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(gallery[i] == -1) continue;
            int start = (i - gallery[i] < 0)? 0 : i - gallery[i];
            int end = (i + gallery[i] >= n)? n - 1 : i + gallery[i];

            Range r = new Range(start, end);
            range.add(r);
        }
        Collections.sort(range, (r1, r2) -> r1.start - r2.start);

        int i = 0, start = 0;
        int count = 0;
        while(start < n) {
            int maxRange = Integer.MIN_VALUE;
            while(i < range.size()) {
                if(range.get(i).start > start) {
                    break;
                }
                maxRange = Math.max(maxRange, range.get(i).end);
                i++;
            }
            if(maxRange < start) return -1;
            count++;
            start = maxRange + 1;
        }

        return count;
    }


    class Range {
        int start;
        int end;
        Range(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
