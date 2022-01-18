// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/palindrome-linked-list/

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
        ListNode* prev = nullptr;
        ListNode* curr = head;
        
        ListNode* temp;
        while(curr) {
            temp = curr -> next;
            curr -> next = prev;
            
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    bool isPalindrome(ListNode* head) {
        ListNode* slow = head;
        ListNode* fast = head;
        
        while(fast && fast -> next) {
            slow = slow -> next;
            fast = fast -> next -> next;
        }
        if(fast) slow = slow -> next;
        
        ListNode* reversedHalf = reverseListIterative(slow);
                    
        while(reversedHalf) {
            if(head -> val != reversedHalf -> val) return false;
            
            reversedHalf = reversedHalf -> next;
            head = head -> next;                
        }
        
        return true;
    }
};