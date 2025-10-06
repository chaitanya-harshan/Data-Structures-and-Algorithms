
package recursion.lec2_subsequences;

import java.util.ArrayList;
import java.util.List;

public class _03_print_subsets_of__num_array {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        // int[] bro = {4,4,4};  // won't work as this is only for unique elements
        List<List<Integer>> list = new ArrayList<>();
        list = subsets(nums);
        for (List<Integer> inner : list) {
            System.out.println(inner);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        generate(list, arr, 0, nums);
        return list;
    }

    static void generate(List<List<Integer>> list, List<Integer> arr, int k, int[] nums) {
        if (k == nums.length) {
            // List<Integer> clone = new ArrayList<>();
            // clone.addAll(arr);
            // list.add(clone);
            list.add(new ArrayList<>(arr)); // cloned so that when arr goes up in the tree and changed then it does't change this one which is added to the list
            return;
        }
        // ** the below explantons is old where i cloned arr to give i/p to both the fucntions below
        // just like arrays this is pass by refrence so u need to clone it so 
        // that the updated list is not backtracked to the upper layers of the recrusion tree
        // structure. else the updated/corrupted list will be passed to the other recursion calls
        // List<Integer> arr1 = new ArrayList<>(arr);
        // List<Integer> arr2 = new ArrayList<>(arr);

        // new explantons-
        // only cloned it when returning and removed the last element form the arr after 2nd F call is done

        generate(list, arr, k+1, nums);
        arr.add(nums[k]);
        generate(list, arr, k+1, nums);
        arr.removeLast(); // to get the original arr which u can return (backtrack) upwards in the tree struture
    }  
}

/*
 * URL: https://leetcode.com/problems/subsets/description/

78. Subsets

Given an integer array nums of unique elements, return all possible  (the power set).
The solution set must not contain duplicate subsets. Return the solution in any order.

 
Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:
Input: nums = [0]
Output: [[],[0]]

 
Constraints:

	1 <= nums.length <= 10
	-10 <= nums[i] <= 10
	All the numbers of nums are unique.
 */


// __________new clean code_____________

 class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        generateSubsets(0, new ArrayList<>());
        return res;
    }

    public void generateSubsets(int i, ArrayList<Integer> list) {
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        generateSubsets(i + 1, list);
        list.add(nums[i]);
        generateSubsets(i + 1, list);
        list.removeLast();
    }
}