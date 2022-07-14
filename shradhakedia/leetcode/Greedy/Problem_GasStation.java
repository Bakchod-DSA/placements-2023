// https://www.interviewbit.com/problems/gas-station/
package leetcode.Greedy;

import java.util.List;

public class Problem_GasStation {
    public int canCompleteCircuit(final List<Integer> A, final List<Integer> B) {
        // total fuel available < total fuel required, then  impossible (-1)
        // else

        int fuelAvailable = 0;
        for(int a : A) {
            fuelAvailable += a;
        }

        int fuelRequired = 0;
        for(int b : B) {
            fuelRequired += b;
        }

        if(fuelAvailable < fuelRequired) return -1;

        int l = 0, fuel = A.get(0) - B.get(0);
        for(int i = 1; i < A.size(); ) {
            if(fuel > 0) {
                fuel += A.get(i) - B.get(i);
                i++;
            } else {
                fuel = A.get(i) - B.get(i);
                l = i;
                i++;
            }
        }

        return l;
    }
}
