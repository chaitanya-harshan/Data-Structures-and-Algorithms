package recursion.lec2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _10_print_unique_subsets {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.nums = nums;
        Arrays.sort(nums);
        backtrack(new ArrayList<>(), 0);
        return result;
    }

    void backtrack(List<Integer> arr, int k) {
        if (k == nums.length) {
            result.add(new ArrayList<>(arr));
            return;
        }

        arr.add(nums[k]);
        backtrack(arr, k+1);
        arr.removeLast();

        while (k+1 < nums.length && nums[k] == nums[k+1]) k++;
        backtrack(arr, k+1);
    }
}

/*
 * URL: https://leetcode.com/problems/subsets-ii/description/

90. Subsets II

Given an integer array nums that may contain duplicates, return all possible  (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

 
Example 1:
Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

 
Constraints:

	1 <= nums.length <= 10
	-10 <= nums[i] <= 10
 */