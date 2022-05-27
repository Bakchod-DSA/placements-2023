/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/reverse-nodes-in-k-group/
 * Difficulty level: Hard
 */
package leetcode.LinkedList;

public class Problem25_ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        return approachOne(head, k);
    }
    private ListNode approachOne(ListNode head, int k) {
        /*  Approach: Recursion
            Time Complexity: O((2k)(n/k)), k => for first while loop, k for reverseList function, (n/k) for recursive calls.
            Space Complexity: O(1) in terms of extra memory, (n/k) for recursive stack calls.
        */
        // base case
        if(head == null) return null;

        // move k nodes ahead.
        ListNode curr = head;
        ListNode prev = null;
        int count = k;
        while(count-- > 0 && curr != null) {
            prev = curr;
            curr = curr.next;
        }
        // separate first k nodes from further nodes
        prev.next = null;
        // recursion call to get the reverse list after k nodes
        ListNode recurNewHead = approachOne(curr, k);
        // reverse this k nodes and attach it to the result of recursive call.
        ListNode newHead = reverseList(head, k, recurNewHead);
        return newHead;
    }

    private ListNode reverseList(ListNode head, int k, ListNode nextHead) {
        // Time Complexity: O(2n)
        if(head == null || length(head) < k) return head;
        ListNode curr = head, newHead = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = newHead;
            newHead =  curr;
            curr = next;
        }
        head.next = nextHead;
        return newHead;
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
}
