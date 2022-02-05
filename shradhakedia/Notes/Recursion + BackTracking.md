# Recursion

- Whenever solving a question, if there is an intuition that given the previous result, can we calculate the required 
  result? If the answer is yes, The choice is recursion.
- It forms the foundation of BackTracking. 
- In tail Recursion, we form recursive stacks and get results as base condition is hit and then the stack keeps on deleting 
  at once, as the result is returned for all frames since the base condition result is received.
- But in Backtracking, we solve multiple sub-problems, and it's not necessary all will contribute to result. 
  There may be some constraints at which some sub problems simply return, and it's stack falls. Overall stack remains 
  till we get all the possible solutions. Here, we get multiple solution when we hit base case several times.
  
## Template

    private static <Return type> function(parameters) {
      
      if(+ve base condition) {
          return base result;
      }

      recurResult = function(parameter modification); // result I got from the immediate previous call.
      myResult = declaration; // my result I am going to send to recursion for next call.
      
      <Modification in recurResult to form myResult>

      return myResult;
    
    }
   
## Examples

- Permutation
- PermutationII
- Combinations
- Power of any number
- Unique Paths
- Climbing Stairs (fibonacci)
- PowerSet
- PowerSetII
- Generate Parentheses
- Sort An Array/ Stack
- Reverse An Array/ Stack
- Reverse A Stack in O(1) space
- Tower Of Hanoi

#### All the above examples lies on this foundation only, that we need to "trust recursion" and give it a base result. It will calculate the previous result we just need to modify it to get our present result. That's it!! We are done.

# BackTracking

## Template 

    private static void function(List<data type> result, <data type> tempResult ...) {
    
      if(+ve base condition) {
        result.add(tempResult);
        return;
      }

      if(-ve base case) {
        return;
      }

      if(condition) { // here, condition is not necessary. Sometimes there is no condition.
        **Modify tempResult**
        function(result, tempResult, parameter modification...);
        **Undo modification in tempResult** -> backtracking
      }

    }


## Examples
- Permutation (NQueens Permutation 1D)
- PermutationII
- Combinations (NQueens Combination 1D)
- PowerSet
- PowerSetII
- Combination Sum
- Combination SumII  
- Generate Parentheses
- NQueens 2D
- Binary Tree Paths

#### All the above examples have almost same templates, and are based on only three different questions.

(Coding blocks) 
- NQueens1D (wrt queen, wrt box)
- NQueens2D when no one attack each other (wrt box)
- Coin Combination
    
## Note: 
 In above written few Examples, certain questions have IInd part also, where duplicates are there, and we need to put
 unique results only, so for that 
 - firstly, **Sort The Array**.
 - Secondly, **Use an extra boolean array to store the last used elements**.
 
We put certain conditions to skip repeated elements, but use them too when required, with the help of boolean array ("used").

    for(int i = 0; i < nums.length; i++) {
      
      if(used[i] || i > 0 && nums[i] == nums[i-1] && !used[i - 1]) {
        continue;
      }
      used[i] = true;
      .
      .
      .
      used[i] = false;

    }  


## [General Templates for all this questions and approaches] (https://leetcode.com/problems/combination-sum/discuss/16502/A-general-approach-to-backtracking-questions-in-Java-(Subsets-Permutations-Combination-Sum-Palindrome-Partitioning )