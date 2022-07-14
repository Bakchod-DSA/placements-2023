// https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1
package leetcode.Greedy;

import java.util.*;

public class Problem_FractionalKnapsack {
    double fractionalKnapsack(int W, Item arr[], int n)
    {
        Arrays.sort(arr, (i1, i2) -> {
            double r1 = (double) i1.value/i1.weight;
            double r2 = (double) i2.value/i2.weight;

            if(r1 < r2) return 1;
            else return -1;
        });

        double maxVal = 0.0;
        for(Item a : arr) {
            if(W > 0) {
                if(W >= a.weight) {
                    maxVal += a.value;
                    W -= a.weight;
                } else {
                    maxVal += (((double) a.value/a.weight) * W);
                    W = 0;
                }
            } else {
                break;
            }
        }

        return maxVal;
    }

    class Item {
        int value, weight;
        Item(int x, int y){
            this.value = x;
            this.weight = y;
        }
    }
}
