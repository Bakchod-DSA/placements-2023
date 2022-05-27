/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/merge-in-between-linked-lists/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem1669_MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode l1Iter = list1;
        ListNode prev = null, next = null;
        b = b - a + 1;
        while(a-- > 0) {
            prev = l1Iter;
            l1Iter = l1Iter.next;
        }
        prev.next = list2;
        while(b-- > 0) {
            l1Iter = l1Iter.next;
        }
        while(list2.next != null) {
            list2 = list2.next;
        }
        list2.next = l1Iter;
        return list1;
    }
}
