package _extras;

import java.util.Arrays;

public class most_freq_ele_frequency {
    
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        int freq = 0;
        int sum = 0;

        while (r < nums.length) {
            sum += nums[r];
            // area = (r-l+1) * nums[r];
            while ( (sum+k) < ((r-l+1)*nums[r]) ) {
                sum -= nums[l];
                l++;
            }          
            freq = Math.max(freq, r-l+1);
            r++;
        }
        return freq;
    }
}

/*
 * 1838. Frequency of the Most Frequent Element
 * https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/
 * https://youtu.be/vgBrQ0NM5vE - neetcode
 * 
The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.

 

Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3.
Example 2:

Input: nums = [1,4,8,13], k = 5
Output: 2
Explanation: There are multiple optimal solutions:
- Increment the first element three times to make nums = [4,4,8,13]. 4 has a frequency of 2.
- Increment the second element four times to make nums = [1,8,8,13]. 8 has a frequency of 2.
- Increment the third element five times to make nums = [1,4,13,13]. 13 has a frequency of 2.
Example 3:

Input: nums = [3,9,6], k = 2
Output: 1
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 105
1 <= k <= 105
 */