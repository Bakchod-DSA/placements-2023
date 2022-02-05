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
   
        mid = low + (high - low)/2
        mid = high - (high - low)/2


2) now, the above two formulas give different values., for e.g. 
        
        if low = 1, high = 8 (8 + 1)/2 = 4
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
   So here, we select our mid as, l + (r - l)/ 2.
   
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

## Template for finding number of rotations in cyclically sorted array:

- **property 1:** Finding minimum in this array is same as finding no. of times the array was rotated.
- E.g. 1 - [2,4,5,6(mid),7,0,1] is rotated 4 times.
- E.g. 2 - [0,1,2,4(mid),5,6,7] is rotated 0 times.
- **property 2:** If arr[mid] > arr[high]; it is for sure that its left part is always less than it (sorted array) . 
  But does not have minimum!! (eg. 1) right part is something like this mid to max element then min to arr[high] (like 7,0,1)
- **property 3:** If arr[mid] < arr[high]; it is for sure that its right part is greater than itself(mid), 
  since sorted array. So, minimum element is on the left.
- **property 4:** The index of the minimum element tells the no. of times the array is rotated.
- **property 5:** In order to calculate the real mid of this rotated array we can use the no. of times rotation 
  was made by the formula -> (calculated mid + no. of rotation) % size of the array.
      
      private int findNumberOfRotations(int[] nums) {  
         int low = 0;
         int high = nums.length - 1;
         while(low < high) {
            int mid = low + ((high - low) >> 1);
            if(nums[mid] < nums[high]) {
               high = mid;
            } else {
               low = mid + 1;
            }
         }
         return nums[high];
      }

## Template for searching a target in cyclically rotated array:

**Formula to calculate real mid:** (calculatedMid + rotation) %  length(array);
      
      private int approachTwo(int[] nums, int target) {
         int rotation = findNumberOfRotations(nums);
         int low = 0;
         int high = nums.length - 1;
         
         while(low <= high) {
            int calculatedMid = low + ((high - low) >> 1);
            int realMid = (calculatedMid + rotation) %  nums.length;
            
            // apply normal binary search now, compare with
            // realMid, but move calculatedMid!!
            if(nums[realMid] < target) {
               low = calculatedMid + 1;
            } else if(nums[realMid] == target) {
               return realMid;
            } else { // nums[realMid] > target
               high = calculatedMid - 1;
            }
         }
         return -1;
      }

## Template for finding number of rotations in cyclically sorted array with duplicates:

        private int numberOfRotation(int[] nums) {
        /* Approach: Binary Search
           Time Complexity: O(n) in worst case, O(log n) in best case(when all unique elements)
           Space Complexity: O(1)
        */

        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            int mid = low + ((high - low) >> 1);

            if(nums[low] == nums[mid] && nums[mid] == nums[high]) {
                // if all three indexes are equal go on the unsorted part
                int flag = -1;
                for(int i = low; i < mid; i++) {
                    // check if left part is unsorted
                    if(nums[i] > nums[i + 1]) {
                        flag = 0;
                        break;
                    }
                }
                for(int i = mid; i < high; i++) {
                    
                    // left part was unsorted, this makes sure right part is sorted
                    if(flag == 0) {
                        break;
                    }
                    // check if right part is unsorted.
                    if(nums[i] > nums[i + 1]) {
                        flag = 1;
                        break;
                    }
                }
                if(flag == 0) {
                    // go to left part as it was unsorted
                    high = mid;
                } else if(flag == 1) {
                    // go to right part as it was unsorted
                    low = mid + 1;
                } else {
                    // return the lowest element as the whole array consisted of equal elements (since, flag remained unset),
                    // so minimum/(first mininium, rest are also equal but index matters when we talk about no. of rotations)
                    // was the one at the index -> low.
                    return nums[low];
                }
            }

            // we go same way, as we do in normal case
            else if(nums[mid] <= nums[high]) {
                high = mid;
            } else { // nums[mid] > nums[high]
                low = mid + 1;
            }
        }
        return nums[high];
    }