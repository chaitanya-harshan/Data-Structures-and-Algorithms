/*
 * 39. Combination Sum
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:

Input: candidates = [2], target = 1
Output: []

https://leetcode.com/problems/combination-sum/
https://youtu.be/GBKI9VSKdGg - neetcode
 */
package recursion.lec2_subsequences;

import java.util.ArrayList;
import java.util.List;

public class _07_combination_sum {
    // ***************** Take & stay || No-take & go-next ********************

    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;
    int target;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        backtrack(0, 0, new ArrayList<>());
        return res;
    }

    public void backtrack(int i, int sum, ArrayList<Integer> list) {
        if (sum > target) return;
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        if (i == candidates.length) return;

        // no take & move to next
        backtrack(i+1, sum, list);

        // take and stay
        // if (sum + candidates[i] <= target) {
            list.add(candidates[i]);
            backtrack(i, sum+candidates[i], list);
            list.removeLast();
        // }
    }

    public void backtrack1(int start, int sum, ArrayList<Integer> list) {
        if (sum == target) {
            res.add(new ArrayList<>(list));
            return;
        }
        
        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) continue;  // or break if array is sorted
            
            list.add(candidates[i]);
            backtrack(i, sum + candidates[i], list);
            list.removeLast();
        }
    }
}

// it's a binary => take it(the current index num) & stay or skip(dont add the curr num) and go to next index
/*
                                  abcd

                                   [],0
                 [a],0                                 [],1
      [aa],0              [a],1              [b],1               [],2
[aaa],0  [aa],1       [ab],1  [a],2      [bb],1  [b],2        [c],2  [],3 
.
.
. continue
if by adding nums[i] to sum, sum exceeds target then we return
*/

