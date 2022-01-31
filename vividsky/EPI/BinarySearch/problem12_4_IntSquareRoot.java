package EPI.BinarySearch;

public class problem12_4_IntSquareRoot {
    public static int squareRoot(int k) {
        if (k == 0 || k == 1) return k;

        int l = 1;
        int h = k/2;
        int ans = -1;

        while (l <= h) {

            int m = l + ((h - l) >> 1);

            if (m == k/m) {
                return m;
            } else if (m > k/m) {
                h = m - 1;
            } else {
                ans = m;
                l = m + 1;
            }
        }
        return ans;
    }
}
