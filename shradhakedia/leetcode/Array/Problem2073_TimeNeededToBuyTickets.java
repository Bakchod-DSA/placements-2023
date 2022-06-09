/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/time-needed-to-buy-tickets/
 * Difficulty level: Easy
 */
package leetcode.Array;

public class Problem2073_TimeNeededToBuyTickets {

    public int timeRequiredToBuy(int[] tickets, int k) {
        int count = 0;
        for(int i = 0; i < tickets.length; i = (i + 1) % tickets.length) {
            if(tickets[k] == 0) {
                return count;
            }
            if(tickets[i] != 0) {
                tickets[i] -= 1;
                count++;
            }
        }
        return count;
    }
}
