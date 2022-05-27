/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/design-linked-list/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

public class Problem707_DesignLinkedList {

    class MyLinkedList {

        ListNode head;
        ListNode curr;

        public MyLinkedList() {
            head = new ListNode(0, null);
        }

        public int get(int index) {
            ListNode curr = head.next;
            while(curr != null && index > 0) {
                curr = curr.next;
                index--;
            }
            return (curr == null)? -1 : curr.val;
        }

        public void addAtHead(int val) {
            ListNode node = new ListNode(val, head.next);
            head.next = node;
        }

        public void addAtTail(int val) {
            ListNode tail = head;
            while(tail.next != null) {
                tail = tail.next;
            }
            ListNode node = new ListNode(val, null);
            tail.next = node;
        }

        public void addAtIndex(int index, int val) {
            ListNode node = new ListNode(val, null);
            ListNode prev = head;
            ListNode curr = head.next;
            while(curr != null && index > 0) {
                prev = curr;
                curr = curr.next;
                index--;
            }
            if(prev != null && index == 0) {
                // we need to check index in case if add at index 1 is there but list is empty, while loop will not run and still prev
                // will add node in its next, if index == 0 is not checked.
                prev.next = node;
                node.next = curr;
            }
        }

        public void deleteAtIndex(int index) {
            ListNode prev = head;
            ListNode curr = head.next;
            while(curr != null && index > 0) {
                prev = curr;
                curr = curr.next;
                index--;
            }
            if(prev != null && curr != null) {
                prev.next = curr.next;
            }
        }

        class ListNode {
            int val;
            ListNode next;

            ListNode(int val, ListNode next) {
                this.val = val;
                this.next = next;
            }
        }
    }

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
}
