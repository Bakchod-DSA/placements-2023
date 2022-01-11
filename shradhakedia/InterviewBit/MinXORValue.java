package InterviewBit;

import java.util.Arrays;

public class MinXORValue {

    public static void main(String[] args) {
        System.out.println(findMinXor(new int[]{0, 4, 7, 9}));
    }


    public static int findMinXor(int[] A) {

        Arrays.sort(A);
        int minXor = Integer.MAX_VALUE;

        for(int i = 0; i < A.length - 1; i++) {
            if((A[i] ^ A[i + 1]) < minXor) {
                minXor = A[i] ^ A[i + 1];
            }
        }

        return minXor;
    }
}
