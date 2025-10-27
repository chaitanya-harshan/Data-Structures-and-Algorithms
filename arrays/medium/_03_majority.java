package arrays.medium;

public class _03_majority {
    // general form of implementing boyce moore ALgo and intuitive(ig)
    public int majorityElement(int[] nums) {
        int ele = nums[0];
        int cnt = 0;
        for (int i: nums) {
            if (cnt == 0) {
                ele = i;
                cnt++;
            }
            else if (i == ele) cnt++;
            else cnt--;
        }
        
        // Not needed as it's mentioned that there exists a majority element
        cnt = 0;
        for (int i: nums) if (i == ele) cnt++;
        return cnt > nums.length/2 ? ele : -1;
    }

    // less intuitive -- not general code so not suggested to use this
    public int majorityElement1(int[] nums) {
        int e = nums[0];
        int cnt = 0;

        for (int i: nums) {
            if (e == i) cnt++;
            else cnt--;

            if (cnt == 0) {
                e = i;
                cnt++;
            }
        }
        return e;
    }

}

/*
https://leetcode.com/problems/majority-element/
169 Majority Element
 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. 
You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */