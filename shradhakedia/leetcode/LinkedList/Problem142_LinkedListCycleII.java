/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/linked-list-cycle-ii/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class Problem142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        // return approachTwo(head);
        return approachOne(head);
    }

    private ListNode approachOne(ListNode head) {
        /*  Approach: Two Pointers(tortoise and hare race)
            Time Complexity: O(n)
            Space Complexity: O(1)
        */
        ListNode slow = head, fast = head;
        boolean isCycle = false;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // does not gaurantee slow and fast meet at the entry of the cycle.
            if(fast != null && fast.equals(slow)) {
                isCycle = true;
                break;
            }
        }

        // cycle exists
        if(isCycle) {
            // start again from beginning to finf the entry point of the cycle.
            slow = head;
            while(!fast.equals(slow)) {
                // fast or slow cannot be null because it is gauranteed now, cycle exists.
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
        return null;

    }

    private ListNode approachTwo(ListNode head) {
        /*  Approach: Hashtable
            Time Complexity: O(n)
            Space Complexity: O(n)
        */
        Set<ListNode> seen = new HashSet<>();
        while(head != null) {
            if(seen.contains(head)) {
                return head;
            } else {
                seen.add(head);
                head = head.next;
            }
        }
        return null;
    }
}
