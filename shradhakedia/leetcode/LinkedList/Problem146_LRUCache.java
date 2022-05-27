/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/lru-cache/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

import java.util.HashMap;

public class Problem146_LRUCache {

    class LRUCache {
        /* Approach: LRU cache uses the same approach as it is internally used in most of the OS.
                     We need to keep track of the given pairs by maintaining a doubly linked list where we can easily remove a node in                      O(1) time due to prev and next pointers. And always add a most recently used node at the tail and remove LRU nodes
                     from head. Also, we maintain a map that keep tracks of key to its corresponding node in the LL. It's easy to get the
                     value of a node using the map, in O(1) time. Thus, HashMap + Linked List gives us O(1) acccess and add/update time.
        */
        HashMap<Integer, Node> map;
        int capacity;
        Node head, tail;

        public LRUCache(int capacity) {
            map = new HashMap<>(capacity);
            this.capacity = capacity;
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            if(map.containsKey(key)) {
                Node node = map.get(key);
                // since it is used recently remove it from old position and add it to tail.
                deleteNode(node);
                addToTail(node);
                return node.val;
            } else {
                return -1;
            }
        }

        public void put(int key, int value) {
            if(map.containsKey(key)) {
                // update it.
                Node node = map.get(key);
                node.val = value;
                // since it is used recently remove node from old position and add updated node to tail.
                deleteNode(node);
                addToTail(node);
            } else {
                Node node = new Node(key, value);
                if(map.size() == capacity) {
                    // capacity not there delete lru node
                    map.remove(head.next.key);
                    deleteNode(head.next);
                }
                // add the node
                map.put(key, node);
                addToTail(node);
            }
        }

        private void deleteNode(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        private void addToTail(Node node) {
            Node prevNode = tail.prev;
            tail.prev = node;
            node.next = tail;
            prevNode.next = node;
            node.prev = prevNode;
        }

        class Node {
            int key;
            int val;
            Node next;
            Node prev;

            Node(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
}
