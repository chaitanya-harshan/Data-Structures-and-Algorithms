package __concepts.binarySearch;

public class zero_arr_transformation_2 {
    // NOT BINARY SEARCH
    public int minZeroArray1(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n];
        int q = 0;
        int decrement = 0;

        for (int i=0; i<n; i++) {
            while (decrement + diff[i] < nums[i]) {
                if (q == queries.length) return -1;

                int l = queries[q][0];
                int r = queries[q][1];
                int val = queries[q][2];
                q++;

                if (r >= i) {
                    diff[Math.max(l,i)] += val;
                    if (r+1 < n) diff[r+1] -= val;
                }
            }
            decrement += diff[i];
        }
        return q;
    }


// ----------------------------------------------------------------------------------------------------------------------
    // BINARY SEARCH
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int low = 0, high = queries.length;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            if (canZero(nums, queries, mid)) {
                high = mid-1;
                ans = mid;
            }
            else low = mid+1;
        }
        return ans;
    }

    public boolean canZero(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n];

        for (int i=0; i<k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if (r+1 < n) diff[r+1] -= val;
        }

        int step = 0;
        for (int i=0; i<n; i++) {
            step += diff[i];
            if (step < nums[i]) return false;
        }
        return true;
    }
}

/*
 * 3356. Zero Array Transformation II
https://leetcode.com/problems/zero-array-transformation-ii/description/

You are given an integer array nums of length n and a 2D array queries where queries[i] = [li, ri, vali].

Each queries[i] represents the following action on nums:

Decrement the value at each index in the range [li, ri] in nums by at most vali.
The amount by which each value is decremented can be chosen independently for each index.
A Zero Array is an array with all its elements equal to 0.

Return the minimum possible non-negative value of k, such that after processing the first k queries in sequence, nums becomes a Zero Array. If no such k exists, return -1.

 

Example 1:

Input: nums = [2,0,2], queries = [[0,2,1],[0,2,1],[1,1,3]]

Output: 2

Explanation:

For i = 0 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [1, 0, 1].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 0, 1] respectively.
The array will become [0, 0, 0], which is a Zero Array. Therefore, the minimum value of k is 2.
Example 2:

Input: nums = [4,3,2,1], queries = [[1,3,2],[0,2,1]]

Output: -1

Explanation:

For i = 0 (l = 1, r = 3, val = 2):
Decrement values at indices [1, 2, 3] by [2, 2, 1] respectively.
The array will become [4, 1, 0, 0].
For i = 1 (l = 0, r = 2, val = 1):
Decrement values at indices [0, 1, 2] by [1, 1, 0] respectively.
The array will become [3, 0, 0, 0], which is not a Zero Array.
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 5 * 105
1 <= queries.length <= 105
queries[i].length == 3
0 <= li <= ri < nums.length
1 <= vali <= 5
 */