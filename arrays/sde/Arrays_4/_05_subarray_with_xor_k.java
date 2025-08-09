package arrays.sde.Arrays_4;

import java.util.HashMap;

public class _05_subarray_with_xor_k {
    
    public static int subarraysWithSumK(int []a, int b) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int cnt = 0;

        for (int i=0;i< a.length; i++) {
            xor = xor ^ a[i];
            // ************here u cant do if else becasue evenif sum == k there might 
            // be smaller sub arr of subecasue of negative nums
            // other way is just add map.put(0,1) before the for loop

            if (xor == b) cnt++;

            // this is not a if else becasue even if == target the curr sum needs to be 
            // added for to check for future checks for new sub array as we proceed
            // If A^target(b) = xor:    xor^b --> A 
            if (map.containsKey(xor ^ b)) {
                cnt += map.get(xor ^ b);
            }

            if (!map.containsKey(xor)) map.put(xor, 1);
            else map.put(xor, map.get(xor)+1);
        }
        return cnt;
        //             /\
        //            /  \
        //       /\  /    |
        //    __/  \/     |
        //   a  b   c     d

        //   sum(d-a) == sum(d-b) == sum[d-c]
        // target == sum => gives sum(d-a)
        // but we should also consider sum(d-c) & sum(d-b)
    }
}

/*
https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqazg2M0NmYktuQlZEZE5MS1FKaTF3bXJWUExtQXxBQ3Jtc0ttTUw2eXlPTUlSYUVRU1FVZElxQ3RTZFRrWllBTGdzVXFpc1FjZEZiV2g1bUdEX01nNE5vUTdmZlJuRWxMZXVYd3F2ajdtSEhjMmhKZE1ndWNBMk85bjlqQl90ZVdrVU9XdFJhcTh6bUVSX3UzMWdtVQ&q=https%3A%2F%2Fbit.ly%2F3jLfElm&v=eZr-6p0B7ME
 * Given an array ‘A’ consisting of ‘N’ integers and an integer ‘B’, find the number of subarrays of array ‘A’ 
 * whose bitwise XOR( ⊕ ) of all elements is equal to ‘B’.
A subarray of an array is obtained by removing some(zero or more) elements from the front and back of the array.



Example:
Input: ‘N’ = 4 ‘B’ = 2
‘A’ = [1, 2, 3, 2]

Output: 3

Explanation: Subarrays have bitwise xor equal to ‘2’ are: [1, 2, 3, 2], [2], [2].
 */