## Template for Fixed sliding window size problem
### Window size(k) is given; Condition(target) is to be found :

    // i represents window’s start, j window’s end, increment j at every step
    // “to make window of size k” and then to “slide window once  
    // maintained”
    while(j < nums.length) {
        // to reduce complexity to O(n)
        add calculation for j
    
        // make window
        if(j - i + 1 < k) {
            j++;
        }
        // once window is made, maintain its size
        else if(j - i + 1 == k) {
            ans = get ans based on calculation
            remove calculations for i;
            i++; // increment i now, to maintain window 
            j++; // increment j now, to maintain window 
        }
    }
    return ans;



## Template for Variable sliding window size problem
### Condition(target) is given; Window size(k) is to be found :
    
    // i represents window’s start, j window’s end, increment j at every step
    // “to make a window that meets condition, target ” and if condition is equal 
    // to target calc. ans and increment j to “check for further larger window”
    // and if condition is greater than target, increment i “to slide window
    // forward to meet target” and increment j once target is maintained.
    // maintained”
    int i = 0, j = 0;
    while(j < nums.length) {
        // to reduce complexity to O(n)
        add calculation for j
        
        if(condition < target) {
            j++;
        }
        else if(condition == target) {
            k = get ans based on calculation;
            j++;
        }
        // condition > target
        else {
            while(condition > target) {
                remove calculations for i;
                i++;
            }
            j++;
        }
    }
    return k;

