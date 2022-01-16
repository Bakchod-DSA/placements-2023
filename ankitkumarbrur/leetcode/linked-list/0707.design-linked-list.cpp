// @author: Ankit
// @user: ankitkumarbrur
// Link: https://leetcode.com/problems/design-linked-list/

 class MyLinkedList {
    
    struct node{
        int value;
        node* next;
        node* prev;
        node(int val): value(val), next(nullptr), prev(nullptr) {}
    };
    
    int size;
    node* head;
    
public:
    MyLinkedList():  head(nullptr), size(0) { }
    
    // Time  Complexity: O(n)
    // Space Complexity: O(1)
    int get(int index) {
        if(index < 0 || index >= size)
            return -1;
                
        node* currentNode = head;
        for(int currentIndex = 0; currentIndex != index;  currentIndex++, currentNode = currentNode -> next);
        
        return currentNode -> value;
    }
    
    // Time  Complexity: O(1)
    // Space Complexity: O(1)
    void addAtHead(int val) {
        node* newNode = new node(val);
        newNode -> next = head;
        head = newNode;
        size++;
    }
    
    // Time  Complexity: O(n)
    // Space Complexity: O(1)
    void addAtTail(int val) {
        node* currentNode = head;
        
        if(currentNode == nullptr)
            addAtHead(val);
        else {
            while(currentNode -> next != nullptr) currentNode = currentNode -> next;
            currentNode -> next = new node(val);
            currentNode -> next -> prev = currentNode;
            size++;

        }
    }
    
    // Time  Complexity: O(n)
    // Space Complexity: O(1)
    void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;   
        
        if(index == 0) {
            addAtHead(val);
        } else {
            node* currentNode = head;
            
            for(int currentIndex = 0; currentIndex != index - 1; currentIndex++)
                currentNode = currentNode -> next;
            
            node* newNode = new node(val);
            
            newNode -> prev = currentNode;
            newNode -> next = currentNode -> next;
            
            currentNode -> next = newNode;
            if(newNode -> next) {
                newNode -> next -> prev = newNode;
            }
            
            size++;
        }
    }
    
    // Time  Complexity: O(n)
    // Space Complexity: O(1)
    void deleteAtIndex(int index) {
        if(index < 0 || index >= size) {
            return;
        }
    
        if(index == 0) {
            head = head -> next;
        } else {
            node* currentNode = head;
            
            for(int currentIndex = 0; currentIndex != index - 1; currentIndex++)
                currentNode = currentNode -> next;

            currentNode -> next = currentNode -> next -> next;
            if(currentNode && currentNode -> next && currentNode -> next -> next) {
                currentNode -> next -> next -> prev = currentNode;
            }
        }
        size--;
    }
};

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList* obj = new MyLinkedList();
 * int param_1 = obj->get(index);
 * obj->addAtHead(val);
 * obj->addAtTail(val);
 * obj->addAtIndex(index,val);
 * obj->deleteAtIndex(index);
 */