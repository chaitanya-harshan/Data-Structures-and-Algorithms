package binary._1D_array;

import java.util.Arrays;

public class _04_floor_ceil {

    public static void main(String[] args) {
        int[] arr = {3, 4, 4, 7, 8, 10};
        int[] arr1 = {3,4,4,7,8,10};
        int[] ans = getFloorAndCeil(arr, arr.length, 5);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(getFloorAndCeil(arr, arr.length, 3)));
        System.out.println(Arrays.toString(getFloorAndCeil(arr, arr.length, 2)));
    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
      int[] ans = new int[2];
      ans[0] = getFloor(a, n, x);
      ans[1] = getCeil(a, n, x);
      return ans;
    }

    public static int getFloor(int[] a, int n, int x) {
      // int floor = -1;
      // int low = 0, high = n-1;
      // while (low <= high) {
      //   int mid = (low + high)/2;
      //   if (a[mid] <= x){
      //     floor = a[mid];
      //     low = mid+1;
      //   }
      //   else high = mid-1;
      // }
      // return floor;

      if (x < a[0]) return -1;
      if (x > a[n-1]) return a[n-1];

      int l = 0, h = n-1;
      while (l <= h) {
        int mid = l+h >> 1;
        if (a[mid] >= x) h = mid - 1;
        else l = mid + 1;
      }
      return a[l] == x ? a[l] : a[l-1];
    }

    public static int getCeil(int[] a, int n, int x) {
      // int ceil = -1;
      // int low = 0, high = n-1;
      // while (low <= high) {
      //   int mid = (low + high)/2;
      //   if (a[mid] >= x){
      //     ceil = a[mid];
      //     high = mid-1;
      //   }
      //   else low = mid+1;
      // }
      // return ceil;

      if (x < a[0]) return a[0];
      if (x > a[n-1]) return -1;

      int l = 0, h = n-1;
      while (l <= h) {
        int mid = l+h >> 1;
        if (a[mid] <= x) l = mid + 1;
        else h = mid - 1;
      }
      return a[h] == x ? a[h] : a[h+1];
    }
}

/*
https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401

 * You're given a sorted array 'a' of 'n' integers and an integer 'x'.



Find the floor and ceiling of 'x' in 'a[0..n-1]'.



Note:
Floor of 'x' is the largest element in the array which is smaller than or equal to 'x'.
Ceiling of 'x' is the smallest element in the array greater than or equal to 'x'.


Example:
Input: 
n=6, x=5, a=[3, 4, 7, 8, 8, 10]   

Output:
4

Explanation:
The floor and ceiling of 'x' = 5 are 4 and 7, respectively.

Sample Input 1 :
6 8
3 4 4 7 8 10


Sample Output 1 :
8 8


Explanation of sample input 1 :
Since x = 8 is present in the array, it will be both floor and ceiling.


Sample Input 2 :
6 2
3 4 4 7 8 10


Sample Output 2 :
-1 3


Explanation of sample input 2 :
Since no number is less than or equal to x = 2 in the array, its floor does not exist. The ceiling will be 3.


Constraints :
1 <= n <= 2 * 10^5      
1 <= a[i] <= 10^9
Time limit: 1 sec
 */