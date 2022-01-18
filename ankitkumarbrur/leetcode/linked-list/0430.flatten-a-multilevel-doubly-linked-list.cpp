// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/

// Time  Complexity: O(n)
// Space Complexity: O(1)

/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* prev;
    Node* next;
    Node* child;
};
*/

class Solution {
public:
    Node* flatten(Node* head) {
        Node* curr = head;
        while(curr) {
            if(curr -> child) {
                Node* nextToChild = curr -> next;
                curr -> next = flatten(curr -> child);
                curr -> child = nullptr;
                curr -> next -> prev = curr;
                
                Node* tail = curr -> next;
                while(tail -> next) tail = tail -> next;
                
                tail -> next = nextToChild;
                if(nextToChild) nextToChild -> prev = tail;
            }
            curr = curr -> next;
        }
        return head;
    }
};