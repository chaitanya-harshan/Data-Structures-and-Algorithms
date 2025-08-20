package greedy.medium;

public class _03_jump_game_2 {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int jumps = 0, maxReach = 0, currentEnd = 0;

        for (int i = 0; i < n - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = maxReach;
                if (currentEnd >= n - 1) break;
            }
        }
        
        return jumps;
    }

    // **********************************************
    // Optimized greedy approach: O(n) | S: O(1)
    // This approach uses a single pass to determine the minimum number of jumps required to reach the last index.
    public int jump1(int[] nums) {
        int curEnd = 0; // not left (this is also right) - limit-right
        int far = 0; // furthest right (boundary) - frontier right
        int n = nums.length;
        int jumps = 0;

        for (int i=0; i<n-1; i++) {
            far = Math.max(far, i + nums[i]);
            if (far >= n-1) return jumps + 1;
            if (i == curEnd) { // current window is expended so now it's time to jump to the nxt window
                jumps++;
                curEnd = far;
            }
        }
        return jumps;
    }


    // recursion TLE: O(n^2) | S: O(n)
    // ___________________________________________________________________________________________ 

    int n;
    int[] nums;
    int[] dp;

    public int jump2(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.dp = new int[n];

        return dfs(0);
    }

    public int dfs(int i) {
        if (i >= n-1) {
            return 0;
        }
        if (dp[i] != 0) return dp[i];

        int min = n;
        for (int j=1; j <= nums[i]; j++) {
            min = Math.min(min, dfs(i+j));
        }
        dp[i] = min + 1;
        return min + 1;
    }
}


/*
 * # [45. Jump Game II](https://leetcode.com/problems/jump-game-ii/description/)

You are given a **0-indexed**  array of integers <code>nums</code> of length <code>n</code>. You are initially positioned atindex 0.

Each element <code>nums[i]</code> represents the maximum length of a forward jump from index <code>i</code>. In other words, if you are at index <code>i</code>, you can jump to any index <code>(i + j)</code>where:

- <code>0 <= j <= nums[i]</code> and
- <code>i + j < n</code>

Return the minimum number of jumps to reach index <code>n - 1</code>. The test cases are generated such that you can reach index<code>n - 1</code>.

**Example 1:** 

```
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
```

**Example 2:** 

```
Input: nums = [2,3,0,1,4]
Output: 2
```

**Constraints:** 

- <code>1 <= nums.length <= 10^4</code>
- <code>0 <= nums[i] <= 1000</code>
- It's guaranteed that you can reach <code>nums[n - 1]</code>.
 */