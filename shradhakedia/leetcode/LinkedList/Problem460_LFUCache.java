/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/lfu-cache/
 * Difficulty level: Hard
 */
package leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Problem460_LFUCache {

    class LFUCache {

        Map<Integer, ListNode> keyToNode;
        Map<Integer, DoubleLinkedList> countToDLL;
        int capacity;
        int minCount;

        public LFUCache(int capacity) {
            this.capacity = capacity;
            this.keyToNode = new HashMap<>();
            this.countToDLL = new HashMap<>();
            this.minCount = 1;
        }

        public int get(int key) {
            if(keyToNode.containsKey(key)) {
                ListNode node = keyToNode.get(key);
                update(node);
                // return value
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if(capacity == 0) return;

            if(keyToNode.containsKey(key)) {
                // update the key value pair
                ListNode node = keyToNode.get(key);
                node.val = value;
                update(node);
            } else {
                // add new key value pair, so first create it.
                ListNode node = new ListNode(key, value);
                if(keyToNode.size() == capacity) {
                    // System.out.println("Inside");
                    // full, remove LFU node.
                    DoubleLinkedList list = countToDLL.get(minCount);
                    ListNode lfuNode = list.head.next;
                    list.removeNode(lfuNode);
                    // remove from keyToNode mapping too.
                    keyToNode.remove(lfuNode.key);
                }
                keyToNode.put(key, node);
                DoubleLinkedList newList = countToDLL.getOrDefault(node.count, new DoubleLinkedList());
                newList.addToTail(node);
                countToDLL.put(node.count, newList);
                minCount = 1; // since we are going to add a new node whose use count will be one.
            }
        }


        private void update(ListNode node) {
            // remove from old count list.
            int count = node.count;
            DoubleLinkedList oldList = countToDLL.get(count);
            oldList.removeNode(node);
            if(oldList.size() == 0 && minCount == count) {
                minCount = count + 1;
            }
            // and add to new count list.
            node.count += 1;
            DoubleLinkedList newList = countToDLL.getOrDefault(node.count, new DoubleLinkedList());
            newList.addToTail(node);
            countToDLL.put(node.count, newList);
        }

        class ListNode {
            int key;
            int val;
            int count;
            ListNode next;
            ListNode prev;
            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
                this.count = 1;
                this.prev = null;
                this.next = null;
            }
        }

        class DoubleLinkedList {
            ListNode head;
            ListNode tail;

            DoubleLinkedList() {
                head = new ListNode(0, 0);
                tail = new ListNode(0, 0);
                head.next = tail;
                tail.prev = head;
            }

            private void removeNode(ListNode node) {
                ListNode prevNode = node.prev;
                ListNode nextNode = node.next;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }

            private void addToTail(ListNode node) {
                ListNode prevNode = tail.prev;
                tail.prev = node;
                node.next = tail;
                node.prev = prevNode;
                prevNode.next = node;
            }

            private int size() {
                int len = 0;
                ListNode curr = head;
                while(curr.next != tail) {
                    curr = curr.next;
                    ++len;
                }
                return len;
            }

        }
    }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
