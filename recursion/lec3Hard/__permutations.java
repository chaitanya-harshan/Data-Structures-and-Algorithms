package recursion.lec3Hard;

import java.util.*;

public class __permutations {
    // You’ve got 4 chairs ([_, _, _, _]) and 4 people ([1,2,3,4]).
    // At each step, you pick who sits in the current chair.
    // Once someone sits, you recurse to seat the rest in the remaining chairs.
    // you swap as a way to remove the element form the remaining elements to choose.(kinda)

    // 1---                   2---                3---  4---
    // 12--  13--  14--       21--  23--  24--
    // 123-  124-             213-  214-
    // 1234  1243             2134  2143
    List<List<Integer>> permutations = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        permute(0);
        return permutations;
    }

    void permute(int i) {
        if (i == nums.length) {
            permutations.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for (int j=i; j<nums.length; j++) {
            swap(i,j);
            permute(i+1);
            swap(i,j);
        }
    }

    void swap(int i, int j) {
        if (i == j) return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    //-------------------------------------------------------------------------------
    public List<List<Integer>> permute1(int[] nums) {
        this.nums = nums;
        HashSet<Integer> set = new HashSet<>();
        for (int i: nums) set.add(i);
        
        permute1(set, new ArrayList<>());
        return permutations;
    }
    void permute1(HashSet<Integer> set, List<Integer> list) {
        if (set.isEmpty()) {
            permutations.add(new ArrayList<>(list));
            return;
        }

        HashSet<Integer> elements = new HashSet<>(set);
        for (int i: elements) {
            list.add(i);
            set.remove(i);
            permute1(set, list);
            set.add(i);
            list.removeLast();
        }
    }
}

/*
 * URL: https://leetcode.com/problems/permutations/description/

46. Permutations

Given an array nums of distinct integers, return all the possible . You can return the answer in any order.

 
Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:
Input: nums = [1]
Output: [[1]]

 
Constraints:

	1 <= nums.length <= 6
	-10 <= nums[i] <= 10
	All the integers of nums are unique.
 */