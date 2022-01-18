// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/linked-list-components/

// Time  Complexity: O(n)
// Space Complexity: O(n)

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
    int numComponents(ListNode* head, vector<int>& nums) {
        bitset<10001> bs;
        for(auto i: nums) bs.set(i);
        
        int connectedComponents = 0;
        bool connected = false;
        while(head) {
            if(bs[head -> val]) {
                if(!connected) connectedComponents++;
                connected = true;
            } else {
                connected = false;
            }
            head = head -> next;
        }
        
        return connectedComponents;
//         unordered_set<int> DS(nums.begin(), nums.end());
//         int res = DS.size();
        
//         while(head && head -> next) {
//             if(DS.find(head -> val) != DS.end() && DS.find(head -> next -> val) != DS.end())
//                 res--;
//             head = head -> next;
//         }
        
//         return res;
    }
};