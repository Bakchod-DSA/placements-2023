package InterviewBit.TwoPointers;

import java.util.*;

public class PairWithGivenDifference {

    public static int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        for(int i = 0, j = 1; i < A.size() && j < A.size(); ) {
            if(i != j && (A.get(j) - A.get(i) == B) || (A.get(i) - A.get(j) == B)) {
                return 1;
            } else if(A.get(j) - A.get(i) < B) {
                j++;
            } else {
                i++;
            }
        }
        return 0;
    }
}
