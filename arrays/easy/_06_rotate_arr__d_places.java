package arrays.easy;

// Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
public class _06_rotate_arr__d_places {
    public void rotateArray(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] arr, int l, int h) {
        if (l >= h) return;

        // int mid = (l + h)/2;
        // while(l <= mid) {
        while(l <= h) {
            int temp = arr[l];
            arr[l] = arr[h];
            arr[h] = temp;

            l++;
            h--;
        }
    }
}


// Given: --> ==>
// Want:  ==> -->

// --> ==> - start
// <-- ==>
// <-- <==

// ==> --> - end