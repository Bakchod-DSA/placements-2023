/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1#
 * Difficulty level: Medium
 */
package ExternalSources.LinkedList;

import java.util.*;

public class problem_FlattenALinkedList {

    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d)
        {
            data = d;
            next = null;
            bottom = null;
        }
    }

    Node flatten(Node root)
    {
        return approachTwo(root);
    }

    Node approachOne(Node root) {
        /*  Approach: Heap, n = no. of next nodes, m = no. of bottom nodes
            Time Complexity: O(nlogn + (n + m)logn), nlogn to build heap of next nodes, (n + m)logn for processing all
                             next and bottom nodes.
            Space Complexity: O(n), at max, heap size will be n i.e. no. of next nodes.
        */
        Node curr = root;
        Queue<Node> minHeap = new PriorityQueue<>((n1, n2) -> n1.data - n2.data);
        while(curr != null) {
            minHeap.offer(curr);
            curr = curr.next;
        }

        Node dummyHead = new Node(0);
        curr = dummyHead;
        while(!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            if(node.bottom != null) {
                minHeap.offer(node.bottom);
            }
            curr.bottom = node;
            curr = curr.bottom;
        }
        return dummyHead.bottom;
    }

    Node approachTwo(Node root) {
        /*  Approach: merge sort, n = no. of next nodes, m = no. of bottom nodes
            Time Complexity: O(n * (n + m)),
            Space Complexity: O(1)
        */
        Node node = null;

        while(root != null) {
            node = merge(node, root);
            root = root.next;
        }

        return node;
    }

    Node merge(Node n1, Node n2) {
        Node dummyHead = new Node(0);
        Node node = dummyHead;

        while(n1 != null && n2 != null) {
            if(n1.data < n2.data) {
                node.bottom = n1;
                n1 = n1.bottom;
            } else {
                node.bottom = n2;
                n2 = n2.bottom;
            }
            node = node.bottom;
        }

        if(n1 != null) {
            node.bottom = n1;
        }
        if(n2 != null) {
            node.bottom = n2;
        }

        return dummyHead.bottom;
    }
}
