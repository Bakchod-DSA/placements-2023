/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/car-pooling/
 * Difficulty level: Medium
 */
package ExternalSources.Sorting;

import java.util.*;

public class Problem1094_CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> timestampToPassenger = new TreeMap<>();

        for(int[] trip : trips) {

            // number of passengers at entry point
            timestampToPassenger.put(trip[1], timestampToPassenger.getOrDefault(trip[1], 0) + trip[0]);
            // number of passengers at exit point
            timestampToPassenger.put(trip[2], timestampToPassenger.getOrDefault(trip[2], 0) - trip[0]);
        }

        for(int numOfPassengers : timestampToPassenger.values()) {
            capacity -= numOfPassengers;
            if(capacity < 0) return false;
        }

        return true;
    }
}
