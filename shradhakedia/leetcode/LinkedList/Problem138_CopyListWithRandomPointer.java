/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/copy-list-with-random-pointer/
 * Difficulty level: Medium
 */
package leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class Problem138_CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        // return approachOne(head);
        return approachTwo(head);
    }

    private Node approachOne(Node head) {
        /*  Approach: HashTable + BruteForce
            Time Complexity: O(n)
            Sapce Complexity: O(n)
        */
        Map<Node, Node> map = new HashMap<>();
        Node newHead = new Node(0);
        Node iter = newHead;
        Node random = null;
        while(head != null) {
            if(!map.containsKey(head)) {
                Node newNode = new Node(head.val);
                map.put(head, newNode);
            }
            iter.next = map.get(head);
            if(random != null && !map.containsKey(random)) {
                Node newRandomNode = new Node(random.val);
                map.put(random, newRandomNode);
            }
            iter.random = (random == null)? null : map.get(random);
            random = head.random;
            iter = iter.next;
            head = head.next;
        }
        iter.random = (random == null)? null : map.get(random);
        return newHead.next;
    }

    private Node approachTwo(Node head) {
        /*  Approach: Optimized approachOne
            Time Complexity: O(3n)
            Sapce Complexity: O(1)
        */
        // Step 1: Iterate the original list and duplicate each node. The duplicate of each node follows its original immediately.
        Node dummyHead = head;
        while(dummyHead != null) {
            Node next = dummyHead.next;
            Node newNode = new Node(dummyHead.val);
            dummyHead.next = newNode;
            newNode.next = next;
            dummyHead = next;
        }

        // Step 2: Iterate the new list and assign the random pointer for each duplicated node.
        dummyHead = head;
        while(dummyHead != null) {
            Node random = dummyHead.random;
            Node duplicateNode = dummyHead.next;
            duplicateNode.random = (random == null)? null : random.next;
            dummyHead = dummyHead.next.next;
        }

        // Step 3: Restore the original list and extract the duplicated nodes.
        dummyHead = head;
        Node newNode = new Node(0);
        Node iter = newNode;
        while(dummyHead != null) {
            Node next = dummyHead.next;
            iter.next = next;
            iter = iter.next;
            dummyHead.next = dummyHead.next.next;
            dummyHead = dummyHead.next;
        }
        return newNode.next;
    }
}
