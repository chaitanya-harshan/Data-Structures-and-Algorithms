package arrays.medium.similar;

import java.util.List;

public class _03_min_idx_valid_split {
    public int minimumIndex(List<Integer> nums) {
        int n = nums.size();
        int ele = nums.get(0);
        int fq = 0;
        for (int i: nums) {
            if (fq == 0) {
                ele = i;
                fq++;
            }
            else if (i == ele) fq++;
            else fq--;
        }

        fq = 0;
        for (int i:nums) if (i == ele) fq++;
        
        // left portion majority_ele_cnt, right portion majority_ele_cnt
        int left = 0, right = fq;
        for (int i=0; i<n; i++) {
            if (nums.get(i) == ele) {
                left++;
                right--;
            }
            if (left > (i+1)/2 && right > (n-1-i)/2) return i;
        }
        return -1;
    }
}

/*
 * URL: https://leetcode.com/problems/minimum-index-of-a-valid-split/description/

2780. Minimum Index of a Valid Split

An element x of an integer array arr of length m is dominant if more than half the elements of arr 
have a value of x.
You are given a 0-indexed integer array nums of length n with one dominant element.

You can split nums at an index i into two arrays nums[0, ..., i] and nums[i + 1, ..., n - 1], 
but the split is only valid if:
0 <= i < n - 1
nums[0, ..., i], and nums[i + 1, ..., n - 1] have the same dominant element.

Here, nums[i, ..., j] denotes the subarray of nums starting at index i and ending at index j, both ends being inclusive. 
Particularly, if j < i then nums[i, ..., j] denotes an empty subarray.
Return the minimum index of a valid split. If no valid split exists, return -1.

 
Example 1:
Input: nums = [1,2,2,2]
Output: 2
Explanation: We can split the array at index 2 to obtain arrays [1,2,2] and [2].
In array [1,2,2], element 2 is dominant since it occurs twice in the array and 2 * 2 > 3.
In array [2], element 2 is dominant since it occurs once in the array and 1 * 2 > 1.
Both [1,2,2] and [2] have the same dominant element as nums, so this is a valid split.
It can be shown that index 2 is the minimum index of a valid split.
Example 2:
Input: nums = [2,1,3,1,1,1,7,1,2,1]
Output: 4
Explanation: We can split the array at index 4 to obtain arrays [2,1,3,1,1] and [1,7,1,2,1].
In array [2,1,3,1,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
In array [1,7,1,2,1], element 1 is dominant since it occurs thrice in the array and 3 * 2 > 5.
Both [2,1,3,1,1] and [1,7,1,2,1] have the same dominant element as nums, so this is a valid split.
It can be shown that index 4 is the minimum index of a valid split.
Example 3:
Input: nums = [3,3,3,3,7,2,2]
Output: -1
Explanation: It can be shown that there is no valid split.

 
Constraints:

	1 <= nums.length <= 105
	1 <= nums[i] <= 109
	nums has exactly one dominant element.
 */