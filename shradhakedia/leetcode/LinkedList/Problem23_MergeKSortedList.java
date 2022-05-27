/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/merge-k-sorted-lists/
 * Difficulty level: Hard
 */
package leetcode.LinkedList;

import java.util.*;

public class Problem23_MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        // Link: https://leetcode.com/problems/merge-k-sorted-lists/solution/
        // return approachOne(lists);
        return approachTwo(new ArrayList<>(Arrays.asList(lists)));
    }

    private ListNode approachOne(ListNode[] lists) {
        /*  Approach: Heap(Priority Queue)
            Time Complexity: O(N logk)
            Space complexity: O(k)
        */
        ListNode merged = new ListNode(0, null);
        ListNode dummyHead = merged;
        Queue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) minHeap.add(lists[i]);
        }

        while(!minHeap.isEmpty()) {
            ListNode smallest = minHeap.poll();
            dummyHead.next = smallest;
            dummyHead = dummyHead.next;
            if(smallest.next != null) minHeap.offer(smallest.next);
        }

        return merged.next;
    }

    private ListNode approachTwo(List<ListNode> lists) {
        /*  Approach: Merge sort (divide and conquer)
            Time Complexity: O(N logk)
            Space complexity: O(1)
        */
        if(lists.size() == 0) return null;
        if(lists.size() == 1) return lists.get(0);

        List<ListNode> result = new ArrayList<>();
        for(int i = 0; i < lists.size(); i += 2) {
            ListNode mergedNode = (i + 1 == lists.size())? mergeTwoLists(lists.get(i), null) : mergeTwoLists(lists.get(i), lists.get(i + 1));
            result.add(mergedNode);
        }
        ListNode recurResult = approachTwo(result);
        return recurResult;
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
