/*
 * 31. Next Permutation
 * 
 *  

Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]

https://leetcode.com/problems/next-permutation/description/
 */

package arrays.sde.Arrays_1;

public class _02_next_permutation {
    
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int index = 0; // left_num_to_peak_idx
        int i = 0;
        for (i=n-1; i> 0; i--) {
            if (nums[i-1] < nums[i]) {
                index = i-1;
                break;
            }
        }
        // 'i' will be 0 only if it's a end case like 321

        // for the case eg: 321
        if (i == 0) {
            reverse(nums, 0, n-1);
            return;
        }

        // to find the nxt element
        // we'll check from end as it's already sorted from end in reverse 
        for (int k = n-1; k > index; k--) {
            if (nums[k] > nums[index]) {
                swap(nums, k, index);
                break;
            }
        }

        reverse(nums, index+1, n-1);
    }

    static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    static void reverse(int[] nums, int start, int end) {
        for (int i= 0; i <= (end-start)/2; i++) { // not end + start
            swap(nums, start + i, end - i);
        }
    }
}
