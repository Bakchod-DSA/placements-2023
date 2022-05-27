/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/reverse-linked-list-ii/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem92_ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        return approachTwo(head, left, right);
    }

    private ListNode approachOne(ListNode head, int left, int right) {
        /*  Approach: iterative
            Time Complexity: O(right)
            Space Complexity: O(1)
        */

        ListNode prev = null, dummy = head;

        while(left > 1) {
            prev = dummy;
            dummy = dummy.next;
            left--;
            right--;
        }

        ListNode node = dummy;
        ListNode newHead = null;
        while(right > 0) {
            ListNode next = node.next;
            node.next = newHead;
            newHead = node;
            node = next;
            right--;
        }

        if(prev != null) prev.next = newHead;
        dummy.next = node;

        return (prev != null)? head : newHead;
    }

    private ListNode approachTwo(ListNode head, int l, int r) {
        /*  Approach: recursive
            Time Complexity: O((r - l) / 2 * r)
            Space Complexity: O((r - l) / 2)
        */

        if(l >= r) {
            return head;
        }

        int ll = l, rr = r;
        ListNode left = head;
        while(l > 1) {
            left = left.next;
            l--;
            r--;
        }

        ListNode right = left;
        while(r > 1) {
            right = right.next;
            r--;
        }

        // swap
        int val = left.val;
        left.val = right.val;
        right.val = val;

        return approachTwo(head, ll + 1, rr  - 1);
    }
}
