/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/product-of-the-last-k-numbers/
 * Difficulty level: Easy
 */
package leetcode.Array;

import java.util.ArrayList;
import java.util.List;

public class Problem1352_ProductOfLastKNumbers {

    class ProductOfNumbers {

        List<Integer> prefixProd;
        int last;
        public ProductOfNumbers() {
            prefixProd = new ArrayList<>();
            last = 1;
        }

        public void add(int num) {
            // Time Complexity: O(1)
            if(num == 0) {
                prefixProd.clear();
                last = 1;
                return;
            }
            last *= num;
            prefixProd.add(last);
        }

        public int getProduct(int k) {
            // Time Complexity: O(1)
            int n = prefixProd.size();
            if(n < k) return 0;
            if(n == k) return prefixProd.get(n - 1);
            else return prefixProd.get(n - 1)/prefixProd.get(n - 1 - k);
        }
    }
}
