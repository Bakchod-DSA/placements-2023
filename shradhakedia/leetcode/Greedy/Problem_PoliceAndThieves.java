// https://practice.geeksforgeeks.org/problems/e47329920b4e75869ea7b0e9b7c59ea145ccc22c/1/#
package leetcode.Greedy;

import java.util.*;

public class Problem_PoliceAndThieves {
    static int catchThieves(char arr[], int n, int k) {
        int catchT = 0;
        List<Integer> police = new ArrayList<>();
        List<Integer> thieves = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'P') police.add(i);
            else thieves.add(i);
        }

        for (int i = 0, j = 0; i < police.size() && j < thieves.size(); ) {
            if (Math.abs(police.get(i) - thieves.get(j)) <= k) {
                i++;
                j++;
                catchT++;
            } else if (police.get(i) > thieves.get(j)) {
                j++;
            } else {
                // police.get(i) < thieves.get(j)
                i++;
            }
        }

        return catchT;
    }
}
