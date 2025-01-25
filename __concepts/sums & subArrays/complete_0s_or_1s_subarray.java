package arrays.sums & subArrays;

public class complete_0s_or_1s_subarray {

    // https://www.naukri.com/code360/problems/count-subarrays-consisting-of-only-0-s-and-only-1-s-in-a-binary-array_1262154?ieSlug=infosys-interview-experience-specialist-programmer-jan-2023-exp-0-2-years&ieCompany=infosys&leftPanelTabValue=PROBLEM
    public static int numberofSubarrays(int n, int[] arr) {
        return count(0, arr) + count(1, arr);
    }

    public static int count(int num, int[] arr) {
        int res = 0;
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                cnt++;
                res += cnt; // factorial-ish logic for total sub arrays for 3,4,..n consecutive
            }
            else cnt = 0;
        }
        return res;
    }
}

/*
 * You are given an array/list consisting of 0 and 1 only. Your task is to find the sum of the number of subarrays that contains only 1 and the number of subarrays that contains only 0.

An array 'C' is a subarray of array 'D' if 'C' can be obtained from 'D' by deletion of several elements from the beginning and several elements from the end. Example :

Let 'ARR' = [1,0,0] then the possible subarrays of 'ARR' will be: {1}, {0}, {0}, {1,0}, {0,0}, {1,0,0}.
Example
If the given array 'ARR' = [1,0,0,0,1,1,0,1]
Then the number of 1’s subarrays will be 5. [{1},{1},{1},{1,1},{1}]
And the number of 0’s subarrays will be 7. [{0},{0},{0},{0,0},{0,0},{0,0,0},{0}]
So our answer will be 5 + 7 = 12.
 */