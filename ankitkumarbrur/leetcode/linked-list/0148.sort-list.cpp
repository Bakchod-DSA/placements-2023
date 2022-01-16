// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/sort-list/

// Time  Complexity: O(nlogn)
// Space Complexity: O(logn)

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
    ListNode* getMid(ListNode* head) {
        ListNode* fast = head;
        ListNode* prev = head;
    
        while(fast && fast -> next) {
            prev = head;
            head = head -> next;
            fast = fast -> next -> next;
        }
        prev -> next = nullptr;
        return head;
    }
    ListNode* merge(ListNode* left, ListNode* right) {
        ListNode* dummy = new ListNode(0, nullptr);
        
        ListNode* head = dummy;
        while(left && right) {
            if(left -> val > right -> val) {
                head -> next = new ListNode(right -> val, nullptr);
                right = right -> next;
            } else {
                head -> next = new ListNode(left -> val, nullptr);
                left = left -> next;
            }
            head = head -> next;
        }
        if(left) head -> next = left;
        else head -> next = right;
        
        return dummy -> next;
    }
public:
    ListNode* sortList(ListNode* head) {
        if(head == nullptr || head -> next == nullptr) return head;
        
        ListNode* mid = getMid(head);
        ListNode* left = sortList(head);
        ListNode* right = sortList(mid);
        return merge(left, right);
    }
};