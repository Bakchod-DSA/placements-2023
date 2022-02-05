/**
 * Author : Sradha Kedia
 * Link   : https://www.youtube.com/watch?v=U81n0UYtk98&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=18
 * Difficulty level : Medium
 */

package CodingBlocks_plus_AdityaVermaSheet.Recursion;

import java.util.*;

public class NBitBinary {

    // All n bit binary nos. where count of set bits are greater than/equal to
    // the count of unset bits in all the prefixes of the binary no.
    public static void main(String[] args) {

        List<String> opList = new ArrayList<>();
        System.out.println(findNBitsBinaryString(4, 0, 0, opList, ""));
    }

    private static List<String> findNBitsBinaryString(int n, int count0, int count1, List<String> opList, String bs) {

        if(n == 0) {
            opList.add(bs);
            return opList;
        }

        if(count1 > count0) {

            findNBitsBinaryString(n - 1, count0 + 1, count1, opList, bs + "0");
        }

        findNBitsBinaryString(n - 1, count0, count1 + 1, opList,bs + "1");

        return opList;

    }

}
