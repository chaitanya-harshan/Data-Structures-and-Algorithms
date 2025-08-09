package arrays.medium;

public class _03_majority_n_by_2 {
    public int majorityElement(int[] nums) {
        int element = 0;
        int cnt = 0;
        // ** You DO cnt-- if the nums[i] != element.
        // Now, since majority element is > combined rest
        // Therefore it is certain that even after element changes, finally the cnt will 
        // be become 0 for the other ele's and the majority element will reign again as 
        // there are more of the tagret elments
        for (int i=0; i<nums.length; i++) {
            if ( cnt == 0) {
                element = nums[i];
                cnt++;
            }
            else if (element == nums[i]) cnt++;
            else cnt--;
        }

        return element;

        
        // int element = 0;
        // int count = 0;
        // for (int i=0; i<nums.length; i++) {
        //     if (count == 0) {
        //         element = nums[i];
        //         count = 1;
        //     }
        //     else if (nums[i] == element) {
        //         count++;
        //     }
        //     else count--;
        // }
        // Not needed as it's mentioned that there exists a majority element

        // int counter = 0;
        // for (int i=0; i<nums.length; i++) {
        //     if (nums[i] == element) counter++;
        // }
        // if (counter > nums.length/2) return element;

        // return -1;

        // return element;
    }
}

/*
https://leetcode.com/problems/majority-element/
169 Majority Element

 * Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */