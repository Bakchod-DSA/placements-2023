# Finding Lower bounds and upper bounds of an element in an array using Binary Search.

## Template for upper bound of an element :

    private int upperBound(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        // low < high and != because then mid would be same as low, high 
        // and if it went in else case it will lead to infinite loop.
        while(low < high) {
            int mid = low + ((high - low) >> 1);
            if(array[mid] == target) {
                return mid;
            } else if(array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        // if no upper bound then low keeps on increasing until it goes 
        // to last index of array
        if(low == array.length - 1 && array[low] < target) return -1;
        return high;
    }


## Template for lower bound of an element :

    private int lowerBound(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        
        // low < high and != because then mid would be same as low, high 
        // and if it went in else if case it will lead to infinite loop.
        while(low < high) {
            int mid = high - ((high - low) >> 1);
            if(array[mid] == target) {
                return mid;
            } else if(array[mid] < target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        // if no lower bound then high keeps on decreasing until it goes to
        // first index of array
        if(high == 0 && array[high] > target) return -1;
        return low;
    }

1) What I learned here, was that first to find mid, the basic formula is (low + high) / 2
But if high is the maximum bound of any specific data type then this can cause overflow. So, it’s a good practice to use
these formulas:
   
       First: mid = low + (high - low)/2
       Second: mid = high - (high - low)/2


2) now, the above two formulas give different values., for e.g. 
        
        if low = 1, high = 8;
        basic formula gives, (8 + 1)/2 = 4
        First gives, 1 + (8 - 1)/2 = 4
        Second gives, 8 - (8 - 1)/2 = 5


3) To calculate lb of 3, eg: 1,2,4,5,7.
   whenever mid < target, this mid can be our valid candidate to lb, so never update low to mid + 1, rather low = mid,
   (we fixed our low and now calculate mid)
   

4) When we select formula 1), l + (r - l)/ 2, we want to make sure to avoid low = mid because that might lead to
   an infinite loop. For example, when there are two elements [0,2] and mid=0, target = lb of 1, then our mid < target, 
   but we again assign low = mid, so again calculated mid is 0(based on the above-mentioned formula) and thus the 
   iteration goes again and again. So here, we select our mid as, r - (r - l)/ 2.
   

5) Similarly, when we calculate the ub, using mid = r - (r - l)/ 2 can lead to infinite loop, as we want to avoid r = mid.
   But, here we need this, as mid > target implies mid is a candidate for ub, so r = mid, 
   So here, we select our mid as, r - (r - l)/ 2.
   
### Note:
    While checking for the existence of an element, use any of these formulas but put low = mid + 1,high = mid - 1. 
    (choose formula to calculate mid, based on the preference of choice of low and high).
  
### Table:
        work                        preference                formula
       - -----------------------------------------------------------------------------------
        To check existence          low = mid + 1             mid = any formula (1 or 2)
                                    right = mid - 1
        
        To find lower bound         low = mid                 mid = high - (high - low)/2
                                    right = mid + 1
        
        To find upper bound         low = mid - 1             mid = low + (high - low)/2
                                    high = mid


