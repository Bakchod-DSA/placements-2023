/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/palindrome-linked-list/
 * Difficulty level: Easy
 */
package leetcode.LinkedList;

public class Problem234_PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        /*
        int n = 0;
        ListNode curr = head;
        while(curr != null) {
            n++;
            curr = curr.next;
        }

        return approachOne(head, 1, n);
        */

        // return approachTwo(head);
        return approachThree(head);
    }

    private boolean approachOne(ListNode head, int l, int r) {
        /*  Approach: Recursion (Gives TLE)
            Time Complexity: O(n ^ 2)
            Space complexity: O(n)
        */

        if(l >= r) return true;

        ListNode left = head;
        int ll = l, rr = r;
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

        if(left.val == right.val) {
            return approachOne(head, ll + 1, rr - 1);
        }
        return false;
    }

    private boolean approachTwo(ListNode head) {
        /*  Approach: brute force
            Time Complexity: O(2n)
            Space complexity: O(1)
        */

        long num = 0, revNum = 0;
        // calculate num
        ListNode curr = head;
        while(curr != null) {
            num = num * 10 + curr.val;
            curr = curr.next;
        }

        // reverse the list
        curr = head;
        ListNode newHead = null;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = newHead;
            newHead = curr;
            curr = next;
        }

        // calculate revNum
        curr = newHead;
        while(curr != null) {
            revNum = revNum * 10 + curr.val;
            curr = curr.next;
        }

        // check if num and revNum are same and hence, palindrome.
        return num == revNum;
    }

    private boolean approachThree(ListNode head) {
        /*  Approach: 2 pointers:- floyd's cycle test i.e. fast and slow pointer.
            Time Complexity: O(n + n/2)
            Space complexity: O(1)
        */

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse list from the middle to end, middle = slow
        ListNode newHead = null;
        while(slow != null) {
            ListNode next = slow.next;
            slow.next = newHead;
            newHead = slow;
            slow = next;
        }

        fast = head;
        slow = newHead;
        while(slow != null && fast.val == slow.val) {
            /*  TC: O(n / 2)
                we check slow != null because we know traversing from back we reach null node before while traversing from front because,
                pointer to the last node of first half list still points to last node of last half list.
                e.g. -> 1 -> 2 -> 2 <- 1, first 2(fast), points to second 2; but second 2(slow), points to null.
                e.g. -> 1 -> 2 <- 1, here middle 2 i.e. fast and slow both are same and points to null. (issue comes in even length list so, we
                manage it by slow pointer check to null).
            */

            // System.out.println(fast.val + ", " + slow.val);
            fast = fast.next;
            slow = slow.next;
        }

        // System.out.println(fast.val + ", " + slow);
        return (slow != null)? false : true;
    }
}
