/**
 * Author : Sradha Kedia
 * Page no.: 252 of Epi Java
 * Problem no.: 14.10
 * Difficulty level : Medium
 */
package EPI.Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem14_10_ComputeASalaryThreshold {

    public static double findSalaryCap(int targetPayroll,
                                       List<Integer> currentSalaries) {
        int n = currentSalaries.size();
        Collections.sort(currentSalaries);
        List<Integer> prefixSum = new ArrayList<>();
        prefixSum.add(currentSalaries.get(0));
        for(int i = 1; i < n; i++) {
            prefixSum.add(prefixSum.get(i - 1) + currentSalaries.get(i));
        }

        int possibleThreshold = n;
        for(int i = 0; i < n; i++) {
            int payrollSum = prefixSum.get(i)  + (currentSalaries.get(i) * (n - i - 1));
            if(payrollSum >= targetPayroll) {
                possibleThreshold = i;
                break;
            }
        }

        int sum = (possibleThreshold == 0)? 0 : prefixSum.get(possibleThreshold - 1);
        double threshold = (targetPayroll - sum + 0.0)/(n - possibleThreshold);
        return threshold;
    }

}
