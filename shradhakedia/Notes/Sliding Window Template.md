## Template for Fixed sliding window size problem
### Window size(k) is given; Condition(target) is to be found :

    // i represents window’s start, j window’s end, increment j at every step
    // “to make window of size k” and then to “slide window once  
    // maintained”
    for(int i = 0, j = 0; j < nums.length; j++) {
        // to reduce complexity to O(n)
        Calculation for each window for j

        // window size maintained
        if(j - i + 1 == k) {
            ans = get ans based on calculation
            Calculations remove for i
            i++; // increment i now, to maintain window 
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
    for(int i = 0, j = 0; j < nums.length; j++) {
        // to reduce complexity to O(n)
        Calculations for each window for j
    
        if(condition == target) {
            k = get ans based on calculation;
        }
        else if(condition > target) {
            while(condition > target) {
                Remove calculations for i;
                i++;
            } 
        }
    }
    return k;
