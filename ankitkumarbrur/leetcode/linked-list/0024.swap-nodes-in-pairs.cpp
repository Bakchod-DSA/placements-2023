// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/swap-nodes-in-pairs/

// Time  Complexity: O(n)
// Space Complexity: O(1)

// Solution 1: Iterative
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
    ListNode* swapPairs(ListNode* head) {
        ListNode* dummy = new ListNode(0, head);
        ListNode* prev = dummy;
        
        while(head && head -> next) {
            prev -> next = head -> next;
            ListNode* temp = head -> next -> next;
            head -> next -> next = head;
            head -> next = temp;
            
            prev = head;
            head = head -> next;
        }
        
        return dummy -> next;
    }
};


// Time  Complexity: O(n)
// Space Complexity: O(n)

// Solution 2: Recursive
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
    ListNode* swapPairs(ListNode* head) {
        if(!head || !head -> next) return head;
        
        ListNode* temp = head -> next;
        head -> next = swapPairs(temp -> next);
        temp -> next = head;
        
        return temp;
    }
};