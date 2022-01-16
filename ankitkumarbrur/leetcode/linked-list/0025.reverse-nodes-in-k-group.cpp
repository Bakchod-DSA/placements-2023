// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/reverse-nodes-in-k-group/

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
    ListNode* reverseKGroup(ListNode* head, int k) {
        ListNode* slow = head;
        int len = 0;
        
        while(slow) len++, slow = slow -> next;
        
        int groups = len/k;
        
        ListNode* dummy = new ListNode(0, head);
        
        ListNode* prev = dummy;
        ListNode* curr = head;
        ListNode* nextNode = nullptr;
        ListNode* prevGroup = dummy;
        while(groups--) {
            ListNode* groupStart = curr;
            int k_copy = k;
            
            while(k_copy--) {
                nextNode = curr -> next;
                curr -> next = prev;
                prev = curr;
                curr = nextNode;
            }

            prevGroup -> next = prev;
            prevGroup = groupStart;
        }
        prevGroup -> next = curr;
        
        return dummy -> next;
    }
};

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
    ListNode* reverseGroup(ListNode* head, int k) {
        ListNode* prev = head;
        ListNode* curr = head -> next;
        ListNode* startNode = curr;
        
        while(k--) {
            ListNode* nextNode = curr -> next;
            curr -> next = prev;
            prev = curr;
            curr = nextNode;
        }
        
        startNode -> next -> next = prev;
        startNode -> next = curr;

        return startNode;
    }
public:
    ListNode* reverseKGroup(ListNode* head, int k) {        
        ListNode* dummy = new ListNode(0, head);

        int len = 0;
        while(head) len++, head = head -> next;
        int groups = len/k;
        
        ListNode* prev = dummy;
        while(groups--) prev = reverseGroup(prev, k);
        
        return dummy -> next;
    }
};

