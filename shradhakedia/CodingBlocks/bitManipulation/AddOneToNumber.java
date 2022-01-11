/**
 * Author : Sradha Kedia
 * Problem   : given n, return n + 1; without using arithmetic operator
 */

package CodingBlocks.bitManipulation;

public class AddOneToNumber {

    public static void main(String[]args){
        System.out.println(addOne(100));
    }

    public static int addOne(int n) {
        int mask = 1;

        while((n & mask) != 0) {
            n ^= mask;
            mask <<= 1;
        }

        return n ^ mask;
    }
}

/**
 * example -> 1011                  1011            1010          1000
 *          +    1            =>     ^ 1     =>     ^ 10        &  100
 *          ------                ------          ------        ------
 *           1100                   1010            1000          1100
 * The main crux here is we keep on flipping bits from right side till we encounter a '0'.
 * flip can be done xor by using a mask -> 1 -> 10 -> 100 -> 1000... and at last when we hit 0 we doing & with the mask.
 * Time Complexity: O(31) worst case, O(1) best case
 */
