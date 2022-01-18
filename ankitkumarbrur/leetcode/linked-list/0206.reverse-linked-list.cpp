// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/reverse-linked-list/

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
    ListNode* reverseListIterative(ListNode* head) {
        ListNode *prev = nullptr;
        ListNode *curr = head;
        
        ListNode* temp;
        while(curr != nullptr) {
            temp = curr -> next;
            curr -> next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    
    ListNode* reverseList(ListNode* head) {
        return reverseListIterative(head);
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
    ListNode* reverseList(ListNode* prev, ListNode* curr) {
        if(curr -> next){
            ListNode* reversed = reverseList(curr, curr->next);
            curr -> next = prev;
            return reversed;
        } else {
            curr -> next = prev;
            return curr;
        }
    }
    ListNode* reverseListRecursive(ListNode* head) {
        if(head && head -> next) {
            ListNode* reversed = reverseList(head, head->next);
            head -> next = nullptr;
            return reversed;
        } else {
            return head;
        }
    }
    
    ListNode* reverseList(ListNode* head) {
        return reverseListRecursive(head);
    }
};