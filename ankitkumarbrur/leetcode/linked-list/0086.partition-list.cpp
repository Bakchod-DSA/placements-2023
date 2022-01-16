// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/partition-list/

// Time  Complexity: O(n)
// Space Complexity: O(1)

// Solution 1
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* dummy = new ListNode(0, head);
        
        ListNode* left = dummy;
        ListNode* prev = dummy;
        ListNode* right = head;
        
        while(right) {
            if(right -> val < x) {
                if(left == prev) {
                    left = left -> next;
                } else {
                    prev -> next = right -> next;
                    right -> next = left -> next;
                    left -> next = right;

                    left = left -> next;
                    right = prev;    
                }
            }
            prev = right;
            right = right -> next;
        }
        return dummy -> next;
    }
};

// Time  Complexity: O(n)
// Space Complexity: O(n)

// Solution 2
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode* leftHead = new ListNode(0, nullptr);
        ListNode* rightHead = new ListNode(0, nullptr);
        
        ListNode* left = leftHead;
        ListNode* right = rightHead;
        
        while(head) {
            if(head -> val < x)
                left = left -> next = head;
            else
                right = right -> next = head;
            
            head = head -> next;
        }
        
        left -> next = rightHead -> next;
        right -> next = nullptr;
        
        return leftHead -> next;
    }
};