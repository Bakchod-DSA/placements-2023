package EPI.BinarySearch;

import java.util.List;

public class problem12_2_SearchEntryEqualToIndex {
    public static int searchEntryEqualToItsIndex(List<Integer> A) {
        int l = 0;
        int h = A.size() - 1;
        while (l <= h) {
            int m = (l + h) >> 1;
            if (A.get(m) == m) {
                return m;
            } else if (A.get(m) > m) {
                h = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;
    }
}
