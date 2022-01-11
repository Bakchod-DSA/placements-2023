/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/add-binary/
 * Difficulty level: Easy
 */

package leetcode.bitManipulation;

public class Problem67_AddBinary {

    public String addBinary(String a, String b) {

        // Approach 1: String and understanding of bits
        StringBuilder sbA = new StringBuilder(a);
        StringBuilder sbB = new StringBuilder(b);
        StringBuilder sbC = new StringBuilder();

        int carry = 0;
        while(sbA.length() > 0 || sbB.length() > 0) {

            char bitA = '0';
            char bitB = '0';
            if(sbA.length() > 0) {
                // charAt takes constant time
                bitA = sbA.charAt(sbA.length() - 1);

                // sbA.deleteCharAt(sbA.length() - 1); => can be O(n) as it
                // copies content into a new array, but setLength() is constant.
                // setLength method simply sets the internal buffer count to the specified                     // new length if the current length is greater than or equal to the new length
                sbA.setLength(sbA.length() - 1);
            }
            if(sbB.length() > 0) {
                bitB = sbB.charAt(sbB.length() - 1);
                sbB.setLength(sbB.length() - 1);
            }

            if(bitA == '0' && bitB == '0') {
                sbC.append("" + carry);
                carry = 0;
            } else if((bitA == '0' && bitB == '1') || (bitA == '1' && bitB == '0')) {
                if(carry == 0) {
                    sbC.append("1");
                } else {
                    sbC.append("0");
                }
            } else {
                if(carry == 0) {
                    sbC.append("0");
                } else {
                    sbC.append("1");
                }
                carry = 1;
            }
        }
        if(carry == 1) sbC.append("1");
        return sbC.reverse().toString();

        // Approach 2:
        // return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);

    }
}

/**
 * Approach 1: String and understanding of bits; Time Complexity: O(max(len a, len b) + n), Space Complexity: O(n)
 */
