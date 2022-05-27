/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/design-hashset/
 * Difficulty level: Easy
 */
package leetcode.LinkedList;

public class Problem705_DesignHashSet {

    class MyHashSet {

        ListNode[] hashTable;
        int size;

        public MyHashSet() {
            size = 101;
            hashTable = new ListNode[size];
        }

        public void add(int key) {
            if(contains(key)) {
                return;
            }
            // hash function
            int index = key % size;
            if(hashTable[index] == null) {
                hashTable[index] = new ListNode(key, null);
            } else {
                ListNode curr = hashTable[index];
                while(curr.next != null) {
                    curr = curr.next;
                }
                curr.next = new ListNode(key, null);
            }
        }

        public void remove(int key) {
            if(!contains(key)) {
                return;
            }
            // hash function
            int index = key % size;
            ListNode curr = hashTable[index];
            ListNode prev = null;
            while(curr.val != key) {
                prev = curr;
                curr = curr.next;
            }
            if(prev == null) {
                hashTable[index] = curr.next;
            } else {
                prev.next = curr.next;
            }
        }

        public boolean contains(int key) {
            // hash function
            int index = key % size;
            if(hashTable[index] == null) {
                return false;
            } else {
                ListNode curr = hashTable[index];
                while(curr != null && curr.val != key) {
                    curr = curr.next;
                }
                return (curr == null)? false : true;
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
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
}
