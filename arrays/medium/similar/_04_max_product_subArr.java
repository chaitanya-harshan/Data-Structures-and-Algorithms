package arrays.medium.similar;

public class _04_max_product_subArr {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1;
        int ans = Integer.MIN_VALUE;

        for (int i: nums) {
            int temp = max;
            // max = Math.max(max*i, Math.max(min*i, i)); // ----------------
            // [++,+]+ [+,-]+  |  [+,-]- [-,--]-  |  [-,-]+
            // max wants to be as max as possible, that includew breaking the sub-arr if
            // both max & min are -ve and i is +ve

            // min = Math.min(temp*i, Math.min(min*i, i)); // ----------------
            // [++,+]- [+,-]-  |  [+,-]+ [-,--]+  |  [-,-]-
            // min wants to be as min as possible, so that in the future if a -ve is 
            // encountered, ans can be flipped to the maximum positive number.
            // That includes even starting a new sub-arr at i if both max & min are -ve
            // and i is -ve which would flip if multiplied so we wont

            // ___________Alternate way of writing the above (intuitive i think)__________
            if (i > 0) {
                max = Math.max(max*i, i); // just i incase max itself is -ve
                min = Math.min(min*i, i); // just i incase min is +ve
            }
            else if (i < 0) {
                max = Math.max(min*i, i); // just i incase min is +ve
                min = Math.min(temp*i, i); // just i incase max(temp) is -ve
            }
            else if (i == 0) {
                max = 1;
                min = 1;
                ans = Math.max(ans, 0);
                continue;
            }

            ans = Math.max(ans, max);
        }
        return ans;
    }
    
    // I don't understand this approach
    public int maxProduct1(int[] nums) {
        int prefix = 1;
        int suffix = 1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (prefix == 0) {
                prefix = 1;
            }
            if (suffix == 0) {
                suffix = 1;
            }

            prefix *= nums[i];
            suffix *= nums[nums.length - 1 - i];

            max = Math.max(max, Math.max(prefix, suffix));
        }
        return max;
    }

}

/*
 * URL: https://leetcode.com/problems/maximum-product-subarray/description/

152. Maximum Product Subarray

Given an integer array nums, find a  that has the largest product, and return the product.
The test cases are generated so that the answer will fit in a 32-bit integer.

 
Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 
Constraints:

	1 <= nums.length <= 2 * 104
	-10 <= nums[i] <= 10
	The product of any subarray of nums is guaranteed to fit in a 32-bit integer.
 */