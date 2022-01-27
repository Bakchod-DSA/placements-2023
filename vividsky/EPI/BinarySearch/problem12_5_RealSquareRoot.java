package EPI.BinarySearch;

public class problem12_5_RealSquareRoot {
    public static double squareRoot(double x) {
    //    return approachOne(x);
        return approachTwo(x);
    }

    private static double approachTwo(double x) {
        double l = 1.0;
        double h = x;
        // If x < 1.0 then it's possible to have x^2 < x
        // Hence to avoid such condition, we put l = x and h = 1.0
        if (x < 1.0) {
            l = x;
            h = 1.0;
        }
        while (compare(l, h) == Ordering.SMALLER) {
            double m = (l + h)/2;
            double square = m * m;
            if (compare(square, x) == Ordering.EQUAL) {
                return m;
            } else if (compare(square, x) == Ordering.LARGER) {
                h = m;
            } else {
                l = m;
            }
        }
        return l;
    }
    enum Ordering {
        SMALLER, LARGER, EQUAL
    }
    private static Ordering compare(double a, double b) {
        final double EPSILON = 0.000001;
        // To find relative difference |a - b| < e -> a == b i.e. -e < a - b < e
        double diff = (a - b)/b;
        return diff < -EPSILON ? Ordering.SMALLER : diff > EPSILON ? Ordering.LARGER : Ordering.EQUAL;
    }

    /**
     *In this approach, I find smallest Integer i such that i^2 <= x and store it in ans
     * then I loop from 1 to precision(number of precision I want for my ans to have)
     * and in each loop, I find largest double with current precision such that i^2 <= x
     * Since double have precision of 16 units, I run my loop 16 times
     *  for e.g. if x = 40, line 51 will return 6 as ans
     *  at each iteration, our ans gets updated as 6.3 -> 6.32 -> 6.324 -> 6.3245 and so on till 6.324555320347....
     */
    private static double approachOne(double x) {
        double precision = 1;
        // Here BS run from 0 - x to find int s.t. i^2 <= x
        double ans = findSquareRoot(x, (long)x, 0, precision);

        // This loop is to find required precision for ans
        for (int k = 1; k <= 16; k++) {
            precision /= 10;
            // Here low = 0 and high = 9 as one decimal place can have value from 0 to 9 at max
            ans = findSquareRoot(x, 9, ans, precision);
        }
        return ans;
    }

    private static double findSquareRoot(double ele, long high, double ans, double precision) {
        long l = 0;
        long h = high;
        long temp = -1;

        while (l <= h) {
            long m = l + (h - l)/2;
            // Here m is multiplied by precision to get required decimal point precision
            double sq = (ans + m * precision) * (ans + m * precision);
            if (sq == ele) {
                return ans + m * precision;
            } else if (sq < ele) {
                temp = m;
                l = m + 1;
            }else {
                h = m - 1;
            }
        }
        return ans + temp * precision;
    }
}
