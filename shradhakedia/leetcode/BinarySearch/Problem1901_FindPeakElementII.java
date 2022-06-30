/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/find-a-peak-element-ii/
 * Difficulty level: Medium
 */
package leetcode.BinarySearch;

public class Problem1901_FindPeakElementII {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        int rowLow = 0, rowHigh = m - 1, colIdx = 0;
        while(rowLow < rowHigh) {
            int rowMid = rowLow + (rowHigh - rowLow)/2;
            colIdx = rowMax(mat[rowMid]);

            if(isGreater(mat, mat[rowMid][colIdx], rowMid + 1, colIdx)) {
                rowHigh = rowMid;
            } else {
                rowLow = rowMid + 1;
            }
        }
        return new int[] {rowHigh, colIdx};

    }

    private boolean isGreater(int[][] mat, int ele, int nextRow, int colIdx) {
        if(nextRow == mat.length) return true;
        return ele > mat[nextRow][colIdx];
    }

    private int rowMax(int[] nums) {
        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 0; i < nums.length; i++) {
            if(max < nums[i]) {
                max = nums[i];
                idx = i;
            }
        }

        return idx;
    }
}
