package EPI.BinarySearch;

import java.util.List;

public class problem12_3_SearchShiftedSortedArray {
    public static int searchSmallest(List<Integer> A) {
        int l = 0;
        int h = A.size() - 1;
        int ans = -1;
        while (l <= h) {
            int m = (l + h) >> 1;
            if (A.get(m) > A.get(A.size() - 1)) {
                l = m + 1;
            } else {
                ans = m;
                h = m - 1;
            }
        }
        return ans;
    }
}
