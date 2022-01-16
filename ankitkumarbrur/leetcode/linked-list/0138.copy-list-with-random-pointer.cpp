// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/copy-list-with-random-pointer/

// Time  Complexity: O(n)
// Space Complexity: O(1)

/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        // Interleaving nodes
        Node* curr = head;
        while(curr) {
            Node* inter = new Node(curr -> val);
            inter -> next = curr -> next;
            curr -> next = inter;
            curr = inter -> next;
        }
        
        // Attach random pointers
        curr = head;
        while(curr) {
            if(curr -> random)
                curr -> next -> random = curr -> random -> next;
            curr = curr -> next -> next;
        }
        
        // Restore lists
        curr = head;
        Node* listCopy  = new Node(0);
        Node* copy = listCopy;
        while(curr) {
            copy -> next = curr -> next;
            curr -> next = curr -> next -> next;
            
            copy = copy -> next;
            curr = curr -> next;
        }
            
        return listCopy -> next;
    }
};