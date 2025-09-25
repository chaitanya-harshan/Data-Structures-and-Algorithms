package arrays.medium.similar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class _08_create_permutations_unique {
    // Everything same. Just need to use a Set
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        permute(0);
        return res;
    }

    void permute(int i) {
        if (i == nums.length) {
            res.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        HashSet<Integer> set = new HashSet<>();
        for (int j=i; j<nums.length; j++) {
            // Here, we use set to prevent creation of duplicates permutations at index i
            if (!set.contains(nums[j])) {
                swap(i, j);
                permute(i+1);
                swap(i, j);
            }
            set.add(nums[j]);
        }
    }

    void swap(int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
 * URL: https://leetcode.com/problems/permutations-ii/description/

47. Permutations II

Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 
Example 1:
Input: nums = [1,1,2]
Output:
[[1,1,2],
[1,2,1],
[2,1,1]]
Example 2:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

 
Constraints:

	1 <= nums.length <= 8
	-10 <= nums[i] <= 10
 */