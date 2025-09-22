package arrays.medium;

import java.util.HashMap;

public class _14_subArrCount {
    // Remember: 1) map stores how many times a {sum} occurs
    //           2) check for (sum-k) before inserting sum (to resolve issue where k = 0)
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int cnt = 0;

        int sum = 0;
        for (int i : nums) {
            sum += i;
            if (sum == k) cnt++;
            if (map.containsKey(sum - k)) cnt += map.get(sum-k);
            // We need to check if (sum-k) exists or not before we put {sum} in the map
            // because if k = 0 then [sum-0] -> [sum] will always exists in case we insert it before.
            // --- The only way we get sum = 0 is when the current sum is 0
            // the other way is when we take empty subArr which isn't possible
            map.put(sum, map.getOrDefault(sum,0) + 1);
            
        }
        return cnt;
    }

    // OLD VERSION
    public int subarraySum1(int[] nums, int k) {
        // you need to watch strivers video to understand
        // time stamp included in the video - 10:42
        // https://youtu.be/xvNwoz-ufXA?si=fOC9hcGBnBDthiIY&t=642
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int cnt = 0;

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (sum == k) cnt++;
            // ************here u cant do if else becasue evenif sum == k there might 
            // be smaller sub arr of subecasue of negative nums
            // other way is just add map.put(0,1) before the for loop
            if (i != 0 && map.containsKey(sum-k)) {
                cnt += map.get(sum-k);
            }
            // this is not a if else becasue even if == target the curr sum needs to be 
            // added for to check for future checks for new sub array as we proceed
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum)+1);
            }
            else map.put(sum, 1);
        }
        return cnt;

        //             /\
        //            /  \
        //       /\  /    |
        //    __/  \/     |
        //   a  b   c     d
        
        //   sum(d-a) == sum(d-b) == sum[d-c]




        // 1 2 3 -3   (1 1 1)  --> sum = 3
            // 1 2   (3 -3 1 1 1)  --> sum = 3
                
            // 1 2 3-3 1 1 1 0 (+) integration
            //     *       * *
            //     *     * * *
            //     *   * * * *
            //   * * * * * * *
            //   * * * * * * *
            // * * * * * * * *
            //     ___________
            //         _______

            //        both give same sum
    }
}

/*
 * Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
 * 
 * Example 1:

Input: nums = [1,1,1], k = 2
Output: 2
Example 2:

Input: nums = [1,2,3], k = 3
Output: 2
 */