/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
 * Difficulty level: Medium
 */
package leetcode.BinarySearch;

public class Problem1011_CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        Pair lowHigh = findLowAndHigh(weights);

        int minCapacity = binarySearch(lowHigh, weights, days);
        return minCapacity;
    }

    private int binarySearch(Pair lowHigh, int[] weights, int days) {
        int low = lowHigh.low;
        int high = lowHigh.high;

        while(low < high) {
            int mid = low + (high - low)/2;
            int expectedDays = findExpectedDaysForGivenCapacity(weights, mid);
            if(expectedDays <= days) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }

    private int findExpectedDaysForGivenCapacity(int[] weights, int capacity) {
        int expectedDays = 0, sum = 0;
        for(int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if(sum > capacity) {
                expectedDays++;
                sum = weights[i];
            } else if(sum == capacity) {
                expectedDays++;
                sum = 0;
            }
        }

        return (sum == 0)? expectedDays : expectedDays + 1;
    }

    private Pair findLowAndHigh(int[] weights) {
        int max = Integer.MIN_VALUE, sum = 0;
        for(int wt : weights) {
            max = Math.max(max, wt);
            sum += wt;
        }

        return new Pair(max, sum);
    }

    class Pair {
        int low;
        int high;
        Pair(int low, int high) {
            this.low = low;
            this.high = high;
        }
    }
}
