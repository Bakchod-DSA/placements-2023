/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * Difficulty level: Easy
 */

package leetcode.TwoPointers;

public class Problem167_TwoSumII {
    
    public int[] twoSum(int[] numbers, int target) {
        
        int[] twoSumTarget = new int[2];
        
        // Approach 1: Brute Force; Time Complexity: O(n^2), Space Complexity: O(1)
        // traverse the outer loop and then a inner loop and check if elements at i, j equals to target         // return, else move forward.
        
        // Approach 2: Two Pointers; Time Complexity: O(n), Space Complexity: O(1)
        for(int i = 0, j = numbers.length - 1; i < j; ) {
            
            if(numbers[i] + numbers[j] == target) {
                twoSumTarget[0] = i + 1;
                twoSumTarget[1] = j + 1;
                
                break;
            }
            else if(numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return twoSumTarget;
        
        
        /*
        // Approach 3: HashMap; Time Complexity: O(n), Space Complexity: O(n)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])) {
                twoSumTarget[0] = map.get(target - numbers[i]) + 1;
                twoSumTarget[1] = i + 1;
                
                break;
            } else {
                map.put(numbers[i], i);
            }
        }
        return twoSumTarget;
        */
        
        /*
        // Approach 4: Binary search; Time Complexity: O(nlogn), Space Complexity: O(1)
        int flag = 0;
        for(int i = 0; i < numbers.length; i++) {
            
            int num = target - numbers[i];
            int low = i + 1;
            int high = numbers.length - 1;
            while(low <= high) {
                int mid = low + ((high - low) >> 1);
                if(numbers[mid] == num) {
                    twoSumTarget[0] = i + 1;
                    twoSumTarget[1] = mid + 1;
                    
                    flag = 1;
                    break;
                } else if(numbers[mid] > num) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            if(flag == 1) {
                break; 
            }
        }
        
        return twoSumTarget;
        */
    }
}
