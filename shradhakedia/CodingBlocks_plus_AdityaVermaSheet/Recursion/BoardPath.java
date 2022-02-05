/**
 * Author : Sradha Kedia
 * Coding Block Problem
 * Difficulty level : Medium
 */

package CodingBlocks_plus_AdityaVermaSheet.Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class BoardPath {

    public static void main(String[] args) {

        System.out.println(getBoardPath(0,10));
    }

    private static ArrayList<String> getBoardPath(int curr, int target) {
        if(curr > target) {
            // negative base case
            return new ArrayList<>();
        }
        if(curr == target) {
            // positive base case
            return new ArrayList<>(Arrays.asList(""));
        }

        ArrayList<String> myList = new ArrayList<>();
        for(int i = 1; i <= 6; i++) {
            ArrayList<String> recurList = getBoardPath(curr + i, target);
            for(String rrs : recurList) {
                myList.add(i + rrs);
            }
        }
        return myList;
    }

}
