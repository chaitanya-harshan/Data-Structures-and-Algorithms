package arrays.easy;
import java.util.HashMap;

public class _13_longSubArrSumK {
    public static void main(String[] args) {
        int[] arr = {2,3,0,0,-1,6,1,9};
        System.out.println(getLongestSubArr(arr, 10));
        int[] arr1 = {-1,1,1};
        System.out.println(getLongestSubArr(arr1, 1));
        // -----------
        System.out.println(getLongestSubArr1(arr, 10));
        System.out.println(getLongestSubArr1(arr1, 1));
        // ----------- **** important
        int[] arr2 = {-13,0,6,15,16,2,15,-12,17,-16,0,-3,19,-3,2,-9,-6}; // ans is 5 for k=15
        System.out.println(getLongestSubArr1(arr2, 15));// will give wrong ans as it has -ve numbers. gives = 1
        System.out.println(getLongestSubArr(arr2, 15)); // ans = 5 which is correct 
    }

    // Optimal for array which contains +ve -ve and zeros

    static int getLongestSubArr(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) maxLength = i+1;
            if (!map.containsKey(sum)) map.put(sum, i);
            if (map.containsKey(sum-k)) {
                int length = i - map.get(sum-k);
                maxLength = Math.max(length, maxLength);
            }
        }
        return maxLength;
    }

    // Optimal if Array has positive and zeros only

     static int getLongestSubArr1( int[] arr, int k) {
        int low = 0;
        int sum = 0;
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            while (sum > k && low <= i) {
                sum -= arr[low];
                low++;
            }
            if (sum == k) maxLength = Math.max(maxLength, i+1-low);
        }
        return maxLength;
     }
}
