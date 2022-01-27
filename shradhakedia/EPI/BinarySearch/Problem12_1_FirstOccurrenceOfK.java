/**
 * Author : Sradha Kedia
 * Page no.: 190, 191 of Epi Java
 * Problem no.: 12.1 variants
 * Difficulty level : Medium
 */

package EPI.BinarySearch;

import java.util.*;

public class Problem12_1_FirstOccurrenceOfK {
    public static void main(String[] args) {
        // List<String> nums = new ArrayList<>(Arrays.asList("aaa", "abcd", "ball", "bat", "cat", "cricket", "dog"));
        // System.out.println(variantFour(nums, "aa"));
    }

    public static int searchFirstOccurrenceOfK(List<Integer> nums, int k) {
        return variantTwo(nums);
    }

    public static int variantOne(List<Integer> nums, int target)   {
        // Approach: Binary Search
        // Time Complexity: O(log n), Space complexity: O(1)

        int low = 0;
        int high = nums.size();
        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if(nums.get(mid) < target) {
                low = mid + 1;
            } else if(nums.get(mid) == target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return high;
    }

    public static int variantTwo(List<Integer> nums) {
        // Approach: Binary Search
        // Time Complexity: O(log n), Space complexity: O(1)

        int low = 0;
        int high = nums.size() - 1;
        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if(nums.get(mid) <= nums.get(mid + 1)) {
                high = mid;
            } else if(nums.get(mid) > nums.get(mid + 1)) {
                low = mid + 1;
            }
        }
        return high;
    }

    public static boolean variantFour(List<String> words, String prefix) {
        // Approach: Binary Search
        // Time Complexity: O(m.log n) where m is length of prefix and n is length of words array,
        // Space complexity: O(1)

        int low = 0;
        int high = words.size() - 1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            String word = words.get(mid);
            if(word.charAt(0) < prefix.charAt(0)) {
                low = mid + 1;
            } else if(word.charAt(0) == prefix.charAt(0)) {
                int flag = 0;
                for(int i = 0; i < prefix.length(); i++) {
                    if(i >= word.length()) {
                        flag = 1;
                        low = mid + 1;
                        break;
                    } else if(prefix.charAt(i) < word.charAt(i)) {
                        flag = 1;
                        high = mid - 1;
                        break;
                    } else if(prefix.charAt(i) > word.charAt(i)) {
                        flag = 1;
                        low = mid + 1;
                        break;
                    }
                }
                if(flag == 0) {
                    return true;
                }
            } else {
                high = mid - 1;
            }
        }
        return false;
    }

}
