/**
 * Author : Sradha Kedia
 * Page no. : 195
 */

package EPI.BinarySearch;

public class Problem12_5_RealSquaredRoot {

    public static void main(String[] args) {
        System.out.println(approachOne(0.0015));
        System.out.println(approachTwo(0.0015));
    }

    private static double approachOne(double x) {
        /*  Approach: Binary Search
            Time Complexity:    O(log x + 16 log 9)
            Space Complexity:   O(1)
            Intuition:  Given a number, we try to find its real sq root one by one for each precision point.
                        eg. 20 has sq root of 4.472135954999579, The idea is to find sq root of 20 one precision at a time.
                        so, firstly we find integer part of sq root by simple binary search. then later we now a decimal
                        digit can be from 0 to 9, so we do binary search on 0 to 9 to find (4.4)^2 <= 20 then
                        (4.47)^2 < 20 and so on for each 16 decimal digit, as the answer is to be returned in double, our
                        sq root has to precise upto 16 decimal places which may still not be the exact root of a no. but
                        greatest sq root smaller than/equal to the no.
        */

        double precision = 1;

        double sqRoot = findSqRoot(x, (long) x, 0, precision);
        for (int i = 1; i < 16; i++) {
            precision /= 10;
            sqRoot = findSqRoot(x, 9, sqRoot, precision);
        }
        return sqRoot;
    }

    private static double findSqRoot(double x, long high, double sqRoot, double precision) {
        long low = 0;
        double temp = 0.0;

        while (low <= high) {
            long mid = low + ((high - low) >> 1);
            double sq = (sqRoot + mid * precision) * (sqRoot + mid * precision);
            if (sq == x) {
                return (sqRoot + mid * precision);
            } else if (sq < x) {
                temp = (sqRoot + mid * precision);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return temp;
    }

    private static double approachTwo(double x) {
        /*  Approach: Binary Search
            Time Complexity:    O(log x)
            Space Complexity:   O(1)
            Intuition:  We used compare() function here to compare two double values set according to the given precision.
        */

        double low, high;
        if (x < 1) {
            low = x;
            high = 1.0;
        } else {
            // x >= 1.0
            low = 1.0;
            high = x;
        }

        while (compare(low, high) == Ordering.SMALLER) {
            double mid = low + ((high - low) / 2);
            double sq = mid * mid;

            if(compare(sq, x) == Ordering.SMALLER) {
                low = mid;
            } else if(compare(sq, x) == Ordering.EQUAL) {
                return mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    private static enum Ordering {
        LARGER, SMALLER, EQUAL
    }

    private static Ordering compare(double a, double b) {
        double EPSILON = 0.000000000000001;

        // if |a - b| < e i.e. - e < a - b < e then, it is considered a = b
        double diff = (a - b)/b;
        return (diff < -EPSILON)? Ordering.SMALLER : (diff > EPSILON)? Ordering.LARGER : Ordering.EQUAL;
    }
}
