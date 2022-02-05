Dynamic Programming (DP) is a programming paradigm that can systematically and efficiently explore all possible solutions to a problem. As such, it is capable of solving a wide variety of problems that often have the following characteristics:

The problem can be broken down into "overlapping sub-problems" - smaller versions of the original problem that are re-used multiple times.
The problem has an "optimal substructure" - an optimal solution can be formed from optimal solutions to the overlapping sub-problems of the original problem.

Bottom-up, also known as tabulation. starts at the base cases.
        uses Iteration
Top-down, also known as memoization.
        uses recursion
        implemented with recursion and made efficient with memoization. If we wanted to find the nth
a top-down dynamic programming approach will be the better option, 
such as when only a fraction of the subproblems need to be solved.

Fibonacci number F(n), we try to compute this by finding F(n - 1) and F(n - 2) until we hit a base case

memoizing a result means to store the result of a function call, usually in a hashmap or an array, so that when the same function call is made again, we can simply return the memoized result instead of recalculating the result.


The first characteristic
DP problems is that the problem will ask for the optimum value (maximum or minimum) of something, 
or the number of ways there are to do something. 

What is the minimum cost of doing...
What is the maximum profit from...
How many ways are there to do...
What is the longest possible...
Is it possible to reach a certain point...

The second characteristic 
that is common in DP problems is that future "decisions" depend on earlier decisions. 
Deciding to do something at one-step may affect the ability to do something in a later step
This is the characteristics where greedy algorithms fails.