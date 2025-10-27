package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;

/**
 * leaders
 */
public class _09_leaders {

    public static void main(String[] args) {
        int[] arr = {16,17,4,3,5,2};
        printLeaders(arr);
    }

    static void printLeaders(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = nums.length;
        int max = nums[n-1];
        for (int i = n-1; i >= 0; i--) {
            if (nums[i] >= max) {
                max = nums[i];
                list.add(nums[i]);
            }
        }
        Collections.reverse(list);
        for(int num: list) 
            System.out.print(num +" ");
    }
}

/*
 * Given an array, print all the elements which are leaders. 
 * A Leader is an element that is greater than all of the elements on its right side in the array.
 
Input:
arr = [4, 7, 1, 0]
Output : 7 1 0
Explanation: Rightmost element is always a leader. 7 and 1 are greater than the elements in their right side.

Example 2:
Input: arr = [10, 22, 12, 3, 0, 6]
Output: 22 12 6
 */