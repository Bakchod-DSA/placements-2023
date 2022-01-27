package EPI.BinarySearch;

import java.util.List;

public class problem12_1_SearchFirstKey {

    public static int searchFirstOfK(List<Integer> A, int k) {

        int l = 0;
        int h = A.size() - 1;
        int ans = -1;

        while (l <= h) {
            int m = (l + h) >> 1;
            if (A.get(m) == k) {
                ans = m;
                h = m - 1;
            } else if (A.get(m) > k) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }
}
