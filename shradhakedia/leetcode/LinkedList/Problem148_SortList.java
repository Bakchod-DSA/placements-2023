/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/sort-list/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem148_SortList {

    public ListNode sortList(ListNode head) {
        return approachOne(head);

    }

    private ListNode approachOne(ListNode head) {
        /*  Approach: Merge Sort(Divide and conquer), Top Down approach
            Time Complexity: O(n * logn)
            Space Complexity: O(logn), recursion stack.
        */

        // if length 0 or 1, no need to sort. can't divide further
        if(head == null || head.next == null)
            return head;
        // find mid and divide/split lists on basis of mid, again call for sorting those divided list.
        ListNode mid = getMid(head);
        ListNode left = sortList(head);
        ListNode right = sortList(mid);
        // merge after getting the sorted list.
        return merge(left, right);
    }

    private ListNode getMid(ListNode head) {
        /*  Approach: Two Pointers(hare and tortoise)
            Time Complexity: O(n/2)
            Space Complexity: O(1)
        */
        ListNode prevMid = new ListNode(0, head);
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            prevMid = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prevMid.next = null;
        return slow;
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        /*  Approach: iterative + inplace
            Time Complexity: O(m + n)
            Space Complexity: O(1), m = list1.length, n = list2.length
        */

        ListNode dummyHead = new ListNode(0, null);
        ListNode current = dummyHead;

        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        current.next = list1 != null? list1 : list2;

        return dummyHead.next;
    }

}
