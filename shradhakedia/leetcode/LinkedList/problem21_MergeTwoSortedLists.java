/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/merge-two-sorted-lists/description/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class problem21_MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // return approachOne(list1, list2);
        // return approachTwo(list1, list2);
        return approachThree(list1, list2);

    }

    private ListNode approachOne(ListNode list1, ListNode list2) {
        /*  Approach: iterative + extra space
            Time Complexity: O(m + n)
            Space Complexity: O(m + n), m = list1.length, n = list2.length
        */

        if(list1 == null && list2 == null) return null;

        ListNode mergedList = new ListNode();
        ListNode mergedListHead = mergedList;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                mergedList.val = list1.val;
                list1 = list1.next;
            } else {
                mergedList.val = list2.val;
                list2 = list2.next;
            }
            mergedList.next = new ListNode();
            mergedList = mergedList.next;
        }

        while(list1 != null) {
            mergedList.val = list1.val;
            if(list1.next != null) {
                mergedList.next = new ListNode();
                mergedList = mergedList.next;
            }
            list1 = list1.next;
        }

        while(list2 != null) {
            mergedList.val = list2.val;
            if(list2.next != null) {
                mergedList.next = new ListNode();
                mergedList = mergedList.next;
            }
            list2 = list2.next;
        }

        return mergedListHead;
    }

    private ListNode approachTwo(ListNode list1, ListNode list2) {
        /*  Approach: recursive
            Time Complexity: O(m + n)
            Space Complexity: O(m + n), m = list1.length, n = list2.length
        */

        if(list1 == null) {
            return list2;
        }
        if(list2 == null) {
            return list1;
        }

        if(list1.val < list2.val) {
            list1.next = approachTwo(list1.next, list2);
            return list1;
        } else {
            list2.next = approachTwo(list1, list2.next);
            return list2;
        }
    }

    private ListNode approachThree(ListNode list1, ListNode list2) {
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
