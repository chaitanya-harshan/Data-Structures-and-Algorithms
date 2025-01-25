package arrays.sums & subArrays;

import java.util.HashMap;

public class subArrCount {
    public int subarraySum(int[] nums, int k) {
        // you need to watch strivers video to understand
        // time stamp included in the video - 10:42
        // https://youtu.be/xvNwoz-ufXA?si=fOC9hcGBnBDthiIY&t=642
        // https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbE1UX2RYUENRNXJNUGZIRTd5WmFEdTNtT3VYUXxBQ3Jtc0ttX1h6Y2JLQ1FzWmtJeGpFNXhvNkNSMzlPTHlLTENUbHRjUTVNXzJhRUJyS2V1VTVlWlhzOHFRQTBlc3hhRVFCbmd1Q3dwZWQtWTBvQ3oxQVRFQzB2bkI3dE1WbnliTFBVQWFYQWM1dktJRldvQnM2bw&q=http%3A%2F%2Fbit.ly%2F3Kn10eZ&v=xvNwoz-ufXA
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int cnt = 0;

        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            if (sum == k) cnt++;
            
            if (map.containsKey(sum-k)) {
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