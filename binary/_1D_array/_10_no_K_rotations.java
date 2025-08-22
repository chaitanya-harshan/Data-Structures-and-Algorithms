package binary._1D_array;

/**
 * _10_K_rotations
 */
public class _10_no_K_rotations {

    public static void main(String[] args) {
        int[] arr1 = {4,5,6,7,1,2,3};
        // int[] arr1 = {11,13,15,17};
        int[] arr = {1};
        System.out.println(findKRotation(arr1));
    }

    public static int findKRotation(int []arr){
        // Write your code here.
        int l =0, h =  arr.length -1;
        int min = Integer.MAX_VALUE;
        int i = -1;

        while (l <= h) {
            int m = l+h >> 1;
            if (arr[l] < arr[h]) {
                if (arr[l] < min) {
                    min = arr[l];
                    i = l;
                }
                break;
            }

            if (arr[l] <= arr[m]) {
                if (arr[l] < min) {
                    min = arr[l];
                    i = l;
                }
                l = m +1;
            }
            else {
                if (arr[m] < min) {
                    min = arr[m];
                    i = m;
                }
                h = m-1;
            }
        }
        return i;
    }
}

/*
 * 
 * https://www.naukri.com/code360/problems/rotation_7449070
 * 
 * You are given an array 'arr' having 'n' distinct integers sorted in ascending order. The array is right rotated 'r' times



Find the minimum value of 'r'.



Right rotating an array means shifting the element at 'ith' index to (‘i+1') mod 'n' index, for all 'i' from 0 to ‘n-1'.



Example:
Input: 'n' = 5 , ‘arr’ = [3, 4, 5, 1, 2]

Output: 3 

Explanation:
If we rotate the array [1 ,2, 3, 4, 5] right '3' times then we will get the 'arr'. Thus 'r' = 3.

Constraints:
1 <= ‘n’ <= 10^5    
1 <= ‘arr[i]’ <= 10^9
Time Limit: 1 sec
 */