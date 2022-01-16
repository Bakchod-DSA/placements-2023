> # *Linked Lists*

1. ## **Using loops to get prev of kth node (single pointer)**
    > ### `0-indexed`
    1. *Starting from HEAD*

        &emsp;k = 3<br/>
        &emsp;0 -> 1 -> 2 -> 3 -> 4 -> 5 <br/>
        &emsp;^&emsp;&emsp;&emsp;&emsp;&emsp;&ensp; ^<br/>
        &emsp;head&emsp;&emsp;&emsp;&emsp;&ensp;k<br/>
        ```cpp
        ListNode* it = head;
        // We need to move pointer 2 times.
        // pre decrement operator can be used to
        // move pointer k - 1 times
        while(--k) it = it -> next;
        ```
    2. *While using dummy node*

        &emsp;k = 3<br/>
        &emsp;dummy -> 0 -> 1 -> 2 -> 3 -> 4 -> 5 <br/>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;^&emsp;&emsp;&emsp;&emsp;&emsp;&ensp; ^<br/>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;head&emsp;&emsp;&emsp;&emsp;&ensp;k<br/>
        ```cpp
        ListNode* it = dummy;
        // We need to move pointer 3 times.
        // post decrement operator can be used to
        // move pointer k times
        while(k--) it = it -> next;
        ```

    > ### `1-indexed`
    1. *Starting from HEAD*

        &emsp;k = 3<br/>
        &emsp;1 -> 2 -> 3 -> 4 -> 5 -> 6 <br/>
        &emsp;^&emsp;&emsp;&emsp;&ensp;^<br/>
        &emsp;head&emsp;&emsp; k<br/>
        ```cpp
        ListNode* it = head;
        k = k - 2;
        // We need to move pointer 2 steps less
        // post decrement operator can be used to
        // move pointer k times
        while(k--) it = it -> next;
        ```
    2. *While using dummy node*

        &emsp;k = 3<br/>
        &emsp;dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 <br/>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;^&emsp;&emsp;&emsp;&ensp;^<br/>
        &emsp;&emsp;&emsp;&emsp;&emsp;&emsp;head&emsp;&emsp; k<br/>
        ```cpp
        ListNode* it = dummy;
        // We need to move pointer 2 times only.
        // pre decrement operator can be used to
        // move pointer k - 1 times
        while(k--) it = it -> next;
        ```

2. ## **Using loops to get prev of kth last node (double pointer)**
    *Starting from `HEAD`* or *`Dummy node`*

    &emsp;k = 2<br/>
    &emsp;0 -> 1 -> 2 -> 3 -> 4 -> 5 <br/>
    &emsp;^&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;^<br/>
    &emsp;head&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&ensp;k<br/>
    ```cpp
    // We need pointer to node with value 3

    ListNode* slow = head;
    ListNode* fast = head;

    // Move fast pointer k times before
    // starting with slow pointer
    while(k--) fast = fast -> next;

    // move slow and fast together unless
    // fast -> next reachces nullptr
    while(fast -> next) {
        slow = slow -> next;
        fast = fast -> next;
    }
    ```

3. ## **Merging k sorted Lists**
    Let,<br/>
    N = total nodes<br/>
    k = total lists<br/>
    N/k = average list length<br/>

    1. ### Divide and Conquer<br/>
        
        Merging two lists of sizes x and y, time = O(x + y) in worst case.

        > ### **Steps:**

        1. First step: <br/>
        Merge `k/2` pairs of lists of lengths `N/k`<br/>
        time complexity = `O(2 N/k * k/2) = O(N)`<br/>
        2. Second step:<br/>
        Merge `k/4` pairs of lists of lengths `2 N/k` (because of step 1, list lengths doubled now)<br/>
        time complexity = `O(4 N/k * k/4) = O(N)`<br/>
        .<br/>
        .<br/>
        3. 2^x step:<br/>
        Merge k / 2^x pairs of lists of lengths `2^(x - 1) N / k`<br/>
        time = `O(2^x N/k * k/2^x) = O(N)`
        <br/><br/>

        All steps take exactly `N` time, and there are `log k` steps,<br/>
        ```
        k / 2^x = 1
        x = log k
        ```
        **Hence, total time complexity = `O(N log k)`** <br/>

        ***NOTE:*** Time complexity will remail same even if lists are unbalanced because it will still take `O(N)` time on each step.<br/>

        ***NOTE:*** For recursive approach we can slove recurrence relation `T(n,k) = 2T(k/2) + O(N)` and get the time complexity `O(N log k)`

    2. ### Merging lists one by one
        Merging list one by one can be represented as,<br/>
        let `n = N/k` for simplicity
        
            n + 2n + ... + kn = n(1 + 2 + .. + k) = n * k * (k + 1) / 2

        Which give us `O(nk^2)` or `O(kN)`