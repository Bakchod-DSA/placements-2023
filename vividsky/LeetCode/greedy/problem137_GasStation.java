package LeetCode.greedy;
/**
 * Author : Nidhi Sangwan
 * User   : vividSky
 * Link   : https://leetcode.com/problems/gas-station/
 * Difficulty level : Medium
 */
public class problem137_GasStation {
    /**
     * Time : O(N)
     * Space : constant
     * Algo : We will fill our gas tank, when we will get negative gas (i.e. we are out of gas)
     * we know that previous start station cannot be a valid one,
     * hence we will consider next station from current one as start station.
     *
     * We keep track of total gas, if total gas needed is more than total gas we had,
     * we can never find a valid start index
     * */
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasInTank = 0;
        int total = 0;
        int station = 0;

        for (int i = 0; i < gas.length; i++) {

            total += gas[i] - cost[i];
            gasInTank += gas[i] - cost[i];

            if (gasInTank < 0) {
                station = i + 1;
                gasInTank = 0;
            }
        }
        return total >= 0 ? station : -1;
    }
}
