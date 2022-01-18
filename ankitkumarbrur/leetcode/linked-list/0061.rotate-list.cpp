// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/rotate-list/

// Time  Complexity: O(n)
// Space Complexity: O(1)

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
    ListNode* rotateRight(ListNode* head, int k) {
        if(!head || !head -> next) return head;
        
        ListNode* curr = head;
        
        int length = 1;
        while(curr -> next) length++, curr = curr -> next;
        
        ListNode* tail = curr;
        curr = head;
        k %= length;
        if(k) {
            k = length - k;
            while(--k) curr = curr -> next;
            
            tail -> next = head;
            head = curr -> next;
            curr -> next = nullptr;
        }
        return head;
    }
};