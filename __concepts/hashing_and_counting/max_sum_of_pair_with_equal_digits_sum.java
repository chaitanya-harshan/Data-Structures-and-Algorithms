
import java.util.HashMap;

public class max_sum_of_pair_with_equal_digits_sum {
    public int maximumSum(int[] nums) {
        int n = nums.length;
        int[] digitSum = new int[n];

        for (int i=0; i<n; i++) {
            int num = nums[i];
            while (num > 0) {
                digitSum[i] += num % 10;
                num /= 10;
            }
        }

        HashMap<Integer, int[]> map = new HashMap<>();
        for (int i=0; i<n; i++) {
            int key = digitSum[i];
            int val = nums[i];

            if (!map.containsKey(key)) map.put(key, new int[]{val,-1});
            else {
                int[] pair = map.get(key);
                if (pair[1] == -1) {
                    if (val > pair[0]) pair[1] = val;
                    else {
                        pair[1] = pair[0];
                        pair[0] = val;
                    }
                }
                else {
                    if (val < pair[0]) continue;
                    else if (val < pair[1] && val > pair[0]) pair[0] = val;
                    else {
                        pair[0] = pair[1];
                        pair[1] = val;
                    }
                }
                map.put(key, pair);
            }
        }

        int max = -1;
        for (int[] pair: map.values()) {
            if (pair[1] != -1) {
                max = Math.max(max, pair[0] + pair[1]);
            }
        }
        return max;

        // HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        // for (int i=0; i<n; i++) {
        //     int key = digitSum[i];
        //     int val = nums[i];
        //     map.computeIfAbsent(key, k -> new PriorityQueue<>((a,b) -> b-a));
        //     map.get(key).offer(val);
        // }

        // int max = -1;
        // for (PriorityQueue<Integer> pq : map.values()) {
        //     if (pq.size() >= 2) {
        //         max = Math.max(max, pq.poll() + pq.poll());
        //     }
        // }
        // return max;
    }
}

/*
 * 2342. Max Sum of a Pair With Equal Sum of Digits
https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/description/

You are given a 0-indexed array nums consisting of positive integers. You can choose two indices i and j, such that i != j, and the sum of digits of the number nums[i] is equal to that of nums[j].

Return the maximum value of nums[i] + nums[j] that you can obtain over all possible indices i and j that satisfy the conditions.

 

Example 1:

Input: nums = [18,43,36,13,7]
Output: 54
Explanation: The pairs (i, j) that satisfy the conditions are:
- (0, 2), both numbers have a sum of digits equal to 9, and their sum is 18 + 36 = 54.
- (1, 4), both numbers have a sum of digits equal to 7, and their sum is 43 + 7 = 50.
So the maximum sum that we can obtain is 54.
Example 2:

Input: nums = [10,12,19,14]
Output: -1
Explanation: There are no two numbers that satisfy the conditions, so we return -1.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
 */