package arrays.sde.Arrays_3;

import java.util.ArrayList;
import java.util.List;

/**
 * _06_reverse_pairs
 */
public class _06_reverse_pairs {

    // you cant do it like inverse pairs sum becasue consider this:
    // 1,2,3     &&    1,3
    // here when comparing 2(left=1) with 1(right=0) then since 1 is smaller, rigth gets
    // incremented before 3(left part) can be compared to 1(right part) as right is incremented.
    // therefore u always need to additionally check using a loop for pairs 
    
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length-1);
    }

    static int mergeSort(int[] nums, int low, int high) {
        if (low == high) return 0;

        int cnt = 0;
        int mid = (low + high) >> 1;
        cnt += mergeSort(nums, low, mid);
        cnt += mergeSort(nums, mid+1, high);
        cnt += countPairs(nums, low, mid, high);
        mergeArrays(nums, low, mid, high);
        return cnt;
    }

    static int countPairs(int[] nums, int low, int mid, int high) {
        int left = low, right = mid+1;
        int cnt = 0;
        while (right <= high) {
            while (left <= mid && (long)nums[left] <= 2*(long)nums[right]) left++;
            cnt += mid - left + 1;
            right++;
        }
        return cnt;
    }
    // static int countPairs(int arr[],int low,int mid,int high){
    //     int right=mid+1;
    //     int count=0;
    //     for(int i=low;i<=mid;i++){
    //         while(right<=high && arr[i]>2*(long)arr[right]){
    //             right++;
    //         }
    //         count+=right-(mid+1);
    //     }
    //     return count;
    // }

    static void mergeArrays(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid+1;
        List<Integer> list = new ArrayList<>();
        
        while (left <= mid || right <= high) {
            if (left <= mid && right <= high) {
                if (nums[left] <= nums[right]) {
                    list.add(nums[left]);
                    left++;
                }
                else {
                    list.add(nums[right]);
                    right++;
                }
            }
            else {
                if (left <= mid) {
                    list.add(nums[left]);
                    left++;
                }
                else if (right <= high) {
                    list.add(nums[right]);
                    right++;
                }
            }
        }
        for (int i = 0; i<list.size(); i++) {
            nums[low + i] = list.get(i);
        }
    }
}

/*
 * 493. Reverse Pairs
 * https://youtu.be/0e4bZaP3MDI - striver
Given an integer array nums, return the number of reverse pairs in the array.

A reverse pair is a pair (i, j) where:

0 <= i < j < nums.length and
nums[i] > 2 * nums[j].
 

Example 1:

Input: nums = [1,3,2,3,1]
Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:

Input: nums = [2,4,3,5,1]
Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 

Constraints:

1 <= nums.length <= 5 * 104
-231 <= nums[i] <= 231 - 1
 */