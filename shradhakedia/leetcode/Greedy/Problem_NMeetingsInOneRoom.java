// https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1/?category
package leetcode.Greedy;

import java.util.*;

public class Problem_NMeetingsInOneRoom {
    public static int maxMeetings(int start[], int end[], int n)
    {
        Meet[] meet = new Meet[n];
        for(int i = 0; i < n; i++) {
            meet[i] = new Meet();
            meet[i].start = start[i];
            meet[i].end = end[i];
        }
        Arrays.sort(meet, (m1, m2) -> m1.start - m2.start);

        List<Meet> ans = new ArrayList<>();
        ans.add(meet[0]);
        for(int i = 1; i < n; i++) {
            Meet prev = ans.get(ans.size() - 1);
            Meet curr = meet[i];
            if(overlap(prev, curr)) {
                if(curr.end < prev.end) ans.set(ans.size() - 1, curr);
            } else {
                ans.add(curr);
            }
        }

        return ans.size();
    }

    private static boolean overlap(Meet meet1, Meet meet2) {
        if(meet2.start <= meet1.end) return true;
        return false;
    }

    static class Meet {
        int start;
        int end;
        Meet() {}
    }
}
