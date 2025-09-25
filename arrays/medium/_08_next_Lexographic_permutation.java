package arrays.medium;

import java.util.Arrays;

public class _08_next_Lexographic_permutation {
    // 1)  Find the Pivot: Starting from the right, find the first digit that is smaller than 
    //     the digit to its right. Let's call this arr[i]. This is our "pivot". All digits to 
    //     the right of the pivot are in descending order (like ...4**8**762).

    // 2)  Find the Successor for [pivot]: Again, starting from the right, find the first digit 
    //     that is larger than the pivot arr[i]. Let's call this arr[j].

    // 3) Swap: Swap the pivot arr[i] and its successor arr[j].

    // 4)  Reverse: Reverse all the digits to the right of the original pivot position i. 
    //     This makes the suffix as small as possible, guaranteeing we have the next permutation.
    public static void main(String[] args) {
        int[] arr = {1,3,2};

        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        // Find the first element from the right (pivot 'l') that is smaller than its right neighbor.
        // This is the "breakpoint" for rearrangement.
        int l = n-2;
        while (l >= 0 && nums[l] >= nums[l+1]) l--;
        
        // If no such pivot exists, the array is in descending order (largest permutation).
        // Reverse the entire array to get the smallest permutation.
        if (l < 0) {
            reverse(nums, 0, n-1);
            return;
        }

        // Find the smallest element to the right of 'l' that is greater than nums[l].
        // This element will be swapped with nums[l] to create the next larger permutation.
        int r = n-1;
        while (nums[l] >= nums[r]) r--; // '>=' because nums has duplicares
        swap(nums, l, r);

        // Reverse the subarray to the right of 'l'.
        // This part was in descending order; reversing it makes it ascending,
        // ensuring the smallest possible increase for the next permutation.
        l++;
        r = n-1;
        reverse(nums, l, r);
    }

    static void reverse(int[] nums, int i, int j) {
        int l = (i+j)/2;
        int r = (i+j+1)/2;
        while (l >= i) {
            swap(nums, l, r);
            l--;
            r++;
        }
    }

    static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

/*
12345
12354
12435
12453
12534
12543

13245
13254
13425
13452
13524
13542

14235
14253

*/

/*
 * URL: https://leetcode.com/problems/next-permutation/description/

31. Next Permutation

A permutation of an array of integers is an arrangement of its members into a sequence or linear order.
For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
The next permutation of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the next permutation of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).
For example, the next permutation of arr = [1,2,3] is [1,3,2].
Similarly, the next permutation of arr = [2,3,1] is [3,1,2].
While the next permutation of arr = [3,2,1] is [1,2,3] because [3,2,1] does not have a lexicographical larger rearrangement.
Given an array of integers nums, find the next permutation of nums.
The replacement must be in place and use only constant extra memory.

 
Example 1:
Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:
Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:
Input: nums = [1,1,5]
Output: [1,5,1]

 
Constraints:

	1 <= nums.length <= 100
	0 <= nums[i] <= 100
 */