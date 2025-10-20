package graphs.shortest_path_algo;

import java.util.*;

public class _10_min_multiplication_steps_to_go_to_end {
    public int minimumMultiplications(int[] arr, int start, int end) {
        if (start == end) return 0;
        
        int MOD = 100_000;
        int[] steps = new int[MOD];
        Arrays.fill(steps, Integer.MAX_VALUE);
        steps[start] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            int m = steps[cur];
            
            for (int i: arr) {
                int num = (cur * i) % MOD;
                // if (num == end) return m + 1;
                // this will create a problem for start == end. 
                // this code is fixed because of the first if statement but this if u dont use 
                // that if-statement then u need to put this check inside the below if-statement
                // so u don't return the large steps u took to return to start by going > 100k and mod
                
                // since i'm using the 1st if-check i'm going to use it here itself
                if (num == end) return m + 1;
                
                // *************************
                // If you're wondering if there is a valid s[num] which is not inf why would
                //  m+1 be < then s[num] because it measn s[num] is already processed by a shorter m
                // then consider this ex: s=2, e=8, arr = [2,4] -> 2-2-2 | 2-4
                // its for cases for checking in the same loop for neighbours.


                // ------------------------------- IMPORTANT - START -------------------------------------------------
                // The if-check is for: Only enqueue if this is the first or shorter path to 'num' but the thing is 
                // we are going on a step-by-step approach so its impossible to have a new path shorter than steps[num]
                // so this check is for only preventing enquing a already discovered node
                // --> alternately u can check: <---
                // if (m+1 == int_max) which will be only true for the 1st discovery
                // or you can
                // just use a visited array like in traditional BFS
                // i'll put an exmaple below to understand the issue
                // ------------------------------- IMPORTANT - END -------------------------------------------------
                if (m + 1 < steps[num]) {
                // if (steps[num] == Integer.MAX_VALUE) {
                // if (!visited[num]) {
                


                    // if (num == end) return m + 1;
                    // above exp on why this needs to be here but again i'm using the 1st if check so 
                    // u don't need to care about this position
                    steps[num] = m + 1;
                    q.offer(num);
                }
            }
        }
        return -1;
    }
}

//example for the above issue i said i'll give:
// arr = [2, 3], start = 2

// steps[2] = 0
// Queue = [2]

// 2*2 = 4   -> steps[4] = 1, enqueue 4
// 2*3 = 6   -> steps[6] = 1, enqueue 6
// Queue = [4, 6]

// 4*2 = 8   -> steps[8] = 2, enqueue 8
// 4*3 = 12  -> steps[12] = 2, enqueue 12
// Queue = [6, 8, 12]

// 6*2 = 12 -> steps[12] ? currently 2, but m+1 = 2 too.
// 6*3 = 18 -> steps[18] = 2, enqueue 18


/*
https://www.geeksforgeeks.org/problems/minimum-multiplications-to-reach-end/1

 * Given start, end and an array arr of n numbers. At each step, start is multiplied with any number in the array and then mod operation with 100000 is done to get the new start.

Your task is to find the minimum steps in which end can be achieved starting from start. If it is not possible to reach end, then return -1.

Example 1:

Input:
arr[] = {2, 5, 7}
start = 3, end = 30
Output:
2
Explanation:
Step 1: 3*2 = 6 % 100000 = 6 
Step 2: 6*5 = 30 % 100000 = 30
Example 2:

Input:
arr[] = {3, 4, 65}
start = 7, end = 66175
Output:
4
Explanation:
Step 1: 7*3 = 21 % 100000 = 21 
Step 2: 21*3 = 63 % 100000 = 63 
Step 3: 63*65 = 4095 % 100000 = 4095 
Step 4: 4095*65 = 266175 % 100000 = 66175
Your Task:
You don't need to print or input anything. Complete the function minimumMultiplications() which takes an integer array arr, an integer start and an integer end as the input parameters and returns an integer, denoting the minumum steps to reach in which end can be achieved starting from start.

Expected Time Complexity: O(105)
Expected Space Complexity: O(105)

Constraints:

1 <= n <= 104
1 <= arr[i] <= 104
1 <= start, end < 105
 */