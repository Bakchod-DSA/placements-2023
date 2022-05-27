/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/linked-list-cycle/
 * Difficulty level: Easy
 */
package leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Problem141_LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        return approachOne(head);
        // return approachTwo(head);
    }

    private boolean approachOne(ListNode head) {
        /*  Approach: Two Pointers(tortoise and hare race)
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        if(head == null) return false;

        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast != null && fast.equals(slow)) {
                return true;
            }
        }

        return false;
    }

    private boolean approachTwo(ListNode head) {
        /*  Approach: Hashtable
            Time Complexity: O(n)
            Space Complexity: O(n)
        */
        if(head == null) return false;
        Set<ListNode> seen = new HashSet<>();
        ListNode curr = head;
        while(curr != null) {
            if(seen.contains(curr)) {
                return true;
            } else {
                seen.add(curr);
            }
            curr = curr.next;
        }

        return false;
    }
}
