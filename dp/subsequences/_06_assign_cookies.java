package dp.subsequences;

import java.util.Arrays;

public class _06_assign_cookies {
    
    public int findContentChildren_basic_greedy_algo(int[] greed, int[] cookie) {
        Arrays.sort(greed);
        Arrays.sort(cookie);

        int g = greed.length, c = cookie.length;
        int i = 0, j = 0;
        while (i < g && j < c) {
            if (greed[i] <= cookie[j]) i++;
            j++;
        }
        return i;
    }

    // ----------------------------------------------------------------------------------------------------------
    // Recursion using take-noTake but it doesnt match the scanario
    public int findContentChildren_recursion(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        // Start with the 0th child and 0th cookie
        return solve(g, s, 0, 0);
    }

    private int solve(int[] g, int[] s, int i, int j) {
        // Base Case 1: We ran out of children
        if (i == g.length) return 0;
        // Base Case 2: We ran out of cookies
        if (j == s.length) return 0;
        
        // Case 1: Cookie is too small. We are forced to skip this cookie.
        if (s[j] < g[i]) return solve(g, s, i, j + 1);
        // Case 2: Cookie is big enough. We have a "Take / NoTake" choice.
        else {
            // Option 1: "Take"
            // We give cookie j to child i. We get 1 point.
            // Move to next child (i + 1) and next cookie (j + 1).
            int take = 1 + solve(g, s, i+1, j+1);
            
            // Option 2: "NoTake"
            // We skip cookie j.
            // Try to feed the same child 'i' with the next cookie (j+1).
            int noTake = solve(g, s, i, j+1);
            // ***********************************
            // this is a useless case cause we know cookie j is the smallest cookie that can satify child i
            // cause both are sorted
            
            // Return the best of the two choices.
            return Math.max(take, noTake);
        }
    }
    /* Optimization: The Greedy Recursion
        The reason this is a "greedy" problem is that in Case 2, the "NoTake" option is never better.
        Since both arrays are sorted, g[i] is the least greedy child remaining.
        s[j] is the smallest cookie remaining that can satisfy this child.
        Giving this smallest cookie to this least greedy child is always an optimal move. 
        There's no benefit to "saving" this small cookie s[j], because any future child g[i+1] is even greedier and might not be satisfied by it.
        So, we can simplify our logic:

        If s[j] >= g[i] (Case 2), we always take the "Take" option. We don't need to explore "NoTake".
        This makes the recursion much simpler and faster (O(n+m) after sorting).
     */
    private int solveGreedy(int[] g, int[] s, int i, int j) {
        if (i == g.length || j == s.length) return 0;

        // Case 1: Cookie is big enough. This is the greedy choice! We MUST take it.
        if (s[j] >= g[i]) return 1 + solveGreedy(g, s, i+1, j+1);
        // Case 2: Cookie is too small. We must skip this cookie and try the next one for the same child.
        else return solveGreedy(g, s, i, j + 1);
    }
}

/*
 * 455. Assign Cookies
 * https://leetcode.com/problems/assign-cookies/description/
 * 
 * 
Assume you are an awesome parent and want to give your children some cookies. But, you should give each 
child at most one cookie.

Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; 
and each cookie j has a size s[j]. 
If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. 
Your goal is to maximize the number of your content children and output the maximum number.

 

Example 1:

Input: g = [1,2,3], s = [1,1]
Output: 1
Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3. 
And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
You need to output 1.
Example 2:

Input: g = [1,2], s = [1,2,3]
Output: 2
Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2. 
You have 3 cookies and their sizes are big enough to gratify all of the children, 
You need to output 2.
 

Constraints:

1 <= g.length <= 3 * 104
0 <= s.length <= 3 * 104
1 <= g[i], s[j] <= 231 - 1
 

Note: This question is the same as 2410: Maximum Matching of Players With Trainers.
 */