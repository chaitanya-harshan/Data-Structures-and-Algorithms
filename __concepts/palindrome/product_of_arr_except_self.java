package __concepts.palindrome;

public class product_of_arr_except_self {
    
    /*
     * Thought Process:
     * 1. For each index i, we need product of all numbers except nums[i]
     * 2. Break this into two parts:
     *    - Product of all numbers to the left of i
     *    - Product of all numbers to the right of i
     * 
     * 3. Two-pass solution:
     *    First pass: Calculate prefix products (left to right)
     *    Second pass: Calculate postfix products (right to left)
     * 
     * Example: [1,2,3,4]
     * First pass (prefix):  [1, 1, 2, 6]
     * Second pass (postfix): [24, 12, 8, 6]
     * 
     * Time: O(n), Space: O(1) (output array not counted)
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int pre = 1, post = 1;

        res[0] = 1;
        for (int i=1; i<n; i++) {
            pre *= nums[i-1];
            res[i] = pre;
        }

        for (int i=n-2; i>=0; i--) {
            post *= nums[i+1];
            res[i] *= post;
        }
        return res;
    }
}

/*
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description/

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

 

Example 1:

Input: nums = [1,2,3,4]
Output: [24,12,8,6]
Example 2:

Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 

Constraints:

2 <= nums.length <= 105
-30 <= nums[i] <= 30
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 */

 