package arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class _10_missingNumber {

    // -----1------

    public int missingNumber1(int[] nums) {
        int length = nums.length;
        HashMap<Integer,Boolean> map = new HashMap<>();
        for (int i = 0; i <= length; i++){
            map.put(i, false);
        }
        for ( int i = 0; i<length; i++){
            map.put(nums[i], true);
        }
        int key = 0;
        for (Map.Entry<Integer,Boolean> entry : map.entrySet()) {
            if (entry.getValue() == false) {
                key = entry.getKey();
                break;
            }
        }
        return key;
    }

    // -----2--------

    public int missingNumber2(int[] nums) {
        int N = nums.length;
        int totalSum = N*(N+1)/2;
        int sum = 0;
        for (int i=0; i<N; i++) {
            sum += nums[i];
        }
        return totalSum - sum;
    }

    //-------3----------

    public static int missingNumber3(int []nums) {

        int N = nums.length;
        int xor1 = 0, xor2 = 0;

        for (int i = 0; i < N; i++) {
            xor2 = xor2 ^ nums[i]; // XOR of array elements
            xor1 = xor1 ^ (i + 1); //XOR up to [1...N]
        }
        return (xor1 ^ xor2); // the missing number
    }
}