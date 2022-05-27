/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/add-two-numbers-ii/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

import java.util.Deque;
import java.util.LinkedList;

public class Problem445_AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return approachTwo(l1, l2);
    }

    private ListNode approachOne(ListNode l1, ListNode l2) {
        /*  Approach: Stack + Elementary maths
            Time Complexity: O(m + n + max(m, n))
            Space Complexity: O(m + n)
        */
        Deque<Integer> stackL1 = new LinkedList<>();
        Deque<Integer> stackL2 = new LinkedList<>();
        ListNode l1Iter = l1, l2Iter = l2;
        while(l1Iter != null) {
            stackL1.addFirst(l1Iter.val);
            l1Iter = l1Iter.next;
        }
        while(l2Iter != null) {
            stackL2.addFirst(l2Iter.val);
            l2Iter = l2Iter.next;
        }

        int carry = 0;
        ListNode newHead = null;
        while(!stackL1.isEmpty() || !stackL2.isEmpty()) {
            int x = (stackL1.isEmpty())? 0 : stackL1.removeFirst();
            int y = (stackL2.isEmpty())? 0 : stackL2.removeFirst();
            int sum = x + y + carry;
            carry = sum / 10;
            ListNode curr = new ListNode(sum % 10, newHead);
            newHead = curr;
        }
        if(carry > 0) {
            ListNode curr = new ListNode(carry, newHead);
            newHead = curr;
        }
        return newHead;
    }

    private ListNode approachTwo(ListNode l1, ListNode l2) {
        /*  Approach: Reversing Linked list + Elementary maths
            Time Complexity: O(m + n + 2max(m,n)), m + n for finding length and 2max(m, n) for adding digits first then for reversing
                             it.
            Space Complexity: O(1)
        */
        int len1 = length(l1), len2 = length(l2);
        ListNode l1Iter = l1, l2Iter = l2;
        ListNode curr = null, newHead = null;
        while(l1Iter != null || l2Iter != null) {
            int x = 0, y = 0;
            if(len1 > len2) {
                x = l1Iter.val;
                y = 0;
                l1Iter = l1Iter.next;
                len1--;
            } else if(len2 > len1) {
                x = 0;
                y = l2Iter.val;
                l2Iter = l2Iter.next;
                len2--;
            } else {
                x = l1Iter.val;
                y = l2Iter.val;
                l1Iter = l1Iter.next;
                l2Iter = l2Iter.next;
            }

            int sum = x + y;
            newHead = new ListNode(sum, curr);
            curr = newHead;
        }
        ListNode result = reverseAndNormalize(newHead);
        return result;
    }
    private int length(ListNode head) {
        // Time Complexity: O(n)
        int len = 0;
        while(head != null) {
            ++len;
            head = head.next;
        }
        return len;
    }

    private ListNode reverseAndNormalize(ListNode head) {
        // Time Complexity: O(n)
        ListNode curr = head;
        ListNode newHead = null;
        int carry = 0;
        while(curr != null) {
            ListNode next = curr.next;
            int val = curr.val + carry;
            carry = val / 10;
            curr.val = val % 10;
            curr.next = newHead;
            newHead = curr;
            curr = next;
        }
        if(carry > 0) {
            newHead = new ListNode(carry, newHead);
        }

        return newHead;
    }
}
