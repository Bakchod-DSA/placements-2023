package leetcode.BinarySearch;

public class Problem875_KokoEatingBananas {

    public int minEatingSpeed(int[] piles, int h) {
        return approachOne(piles, h);
    }

    private int approachOne(int[] piles, int h) {
        /*  Approach One: Brute Force; caused TLE.
            Time Complexity: O(n*minSpeed), Space Complexity: O(1)
        */

        int minSpeed = 1;
        while(true) {
            long sum = 0;
            for(int pile : piles) {
                sum += ((pile + minSpeed - 1)/minSpeed);
            }

            if(sum <= h) {
                break;
            } else {
                minSpeed++;
            }
        }

        return minSpeed;
    }

    private int approachTwo(int[] piles, int h) {
        /*  Approach Two: Binary Search;
            Time Complexity: O(n + nlogm), m is max of the array, Space Complexity: O(1)
        */

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++) {
            max = Math.max(max, piles[i]);
        }

        return upperBound(piles, h, 1, max);
    }

    private int upperBound(int[] piles, int hours, int low, int high) {

        while(low < high) {
            int mid = low + ((high - low) >> 1);
            int sum = 0;
            for(int pile : piles) {
                // calculating Math.ceil(pile/mid) = (pile + mid - 1)/mid;
                sum += ((pile + mid - 1)/mid);
            }
            if(sum <= hours) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return high;
    }
}
