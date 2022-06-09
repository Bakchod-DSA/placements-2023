/**
 * Author : Sradha Kedia
 * User   : ShradhaKedia
 * Link   : https://leetcode.com/problems/design-browser-history/
 * Difficulty level: Medium
 */
package leetcode.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class Problem1472_DesignBrowserHistory {

    class BrowserHistory {

        Deque<String> future;
        Deque<String> history;

        public BrowserHistory(String homepage) {
            future = new LinkedList<>();
            history = new LinkedList<>();
            history.addFirst(homepage);
        }

        public void visit(String url) {
            future.clear();
            history.addFirst(url);
        }

        public String back(int steps) {
            while(history.size() > 1 && steps > 0) {
                steps--;
                future.addFirst(history.removeFirst());
            }
            return history.peekFirst();
        }

        public String forward(int steps) {
            while(future.size() > 0 && steps > 0) {
                steps--;
                history.addFirst(future.removeFirst());
            }
            return history.peekFirst();
        }
    }

/*
// approachOne
class BrowserHistory {

    DoubleLinkedList dll;
    Node homepageNode;
    Node curr;

    public BrowserHistory(String homepage) {
        dll = new DoubleLinkedList();
        homepageNode = new Node(homepage);
        dll.addNode(dll.head, homepageNode);
        curr = homepageNode;
    }

    public void visit(String url) {
        Node newNode = new Node(url);
        dll.addNode(curr, newNode);
        curr = newNode;
    }

    public String back(int steps) {
        while(curr.prev != dll.head && steps > 0) {
            steps--;
            curr = curr.prev;
        }
        return curr.url;
    }

    public String forward(int steps) {
        while(curr.next != dll.tail && steps > 0) {
            steps--;
            curr = curr.next;
        }
        return curr.url;
    }

    class DoubleLinkedList {
        Node head;
        Node tail;

        DoubleLinkedList() {
            head = new Node("");
            tail = new Node("");
            head.next = tail;
            tail.prev = head;
        }

        private void addNode(Node oldNode, Node newNode) {
            oldNode.next = newNode;
            newNode.prev = oldNode;
            newNode.next = tail;
            tail.prev = newNode;
        }
    }

    class Node {
        String url;
        Node next;
        Node prev;

        Node(String url) {
            this.url = url;
            this.next = null;
            this.prev = null;
        }
    }
}
*/

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
}
