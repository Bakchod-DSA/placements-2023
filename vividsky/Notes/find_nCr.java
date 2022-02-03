package Notes;

public class find_nCr {

    private int findCombinations(int n, int r) {

        if (r > n) {
            n = n + r;
            r = n - r;
            n = n - r;
        }
        long result = 1;
        for (int i = 1; i <= r; i++) {
            result *= n - r + i;
            result /= i;
        }
        return (int)result;
    }
}
