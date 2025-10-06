/*
 * 40. Combination Sum II
Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[[1,1,6],
[1,2,5],
[1,7],
[2,6]]

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[[1,2,2],
[5]]

https://leetcode.com/problems/combination-sum-ii/description/
 */
package recursion.lec2_subsequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _08_combination_sum2 {

    public static void main(String[] args) {
        int target;
        // int[] nums = {1,2,3};
        // int[] nums = {10,1,2,7,6,1,5}; target = 8;
        // int[] nums = {2,5,2,1,2}; target = 5;//
        int[] nums = {1,1,1,2,2}; target = 4; 
        List<List<Integer>> list = new ArrayList<>();
        list = combinationSum2(nums, target);

        // for (List<Integer> inner : list) {
        //     System.out.println(inner);
        // }
        // System.out.println("size "+list.size());
        System.out.println(list);
    }
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // *********
        backtrack(res, new ArrayList<>(), 0, target, candidates);
        return res;
    }

    static void backtrack1(List<List<Integer>> res, List<Integer> list, int k, int target, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (k == candidates.length) return;

        if (candidates[k] <= target) {
            list.add(candidates[k]);
            backtrack(res, list, k+1, target-candidates[k], candidates);
            list.removeLast();
        }
        
        while (k+1 < candidates.length && candidates[k] == candidates[k+1]) k++;
        backtrack(res, list, k+1, target, candidates);

        // ----LIKE in 3-sum & 4-sum-----
        // k++;
        // while (k < candidates.length && candidates[k] == candidates[k-1]) k++;
        // backtrack(res, list, k, target, candidates);
    }

//                                         abbcd

//                                          [],0
//                  [a],1                                         [],1
//       [ab],2              [a],3{2}x              [b],2                   [],3{2}x
// [abb],3  [ab],3       [ac],4  [a],4          [bb],3  [b],3{2}x      [c],4    [],4 



    // recursion tree photo in images
    static void backtrack(List<List<Integer>> res, List<Integer> list, int k, int target, int[] candidates) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        // if (k == candidates.length) return; // not needed as k<len is already checked in for-loop

        // k = start index
        for (int i=k; i < candidates.length; i++) {
            if (i != k && candidates[i] == candidates[i-1]) continue;

            if (candidates[i] <= target) {
                list.add(candidates[i]);
                backtrack(res, list, i+1, target-candidates[i], candidates);
                list.removeLast();
            }
            else break;
        }
    }
}
