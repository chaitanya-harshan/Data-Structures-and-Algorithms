package __concepts.lexographic_and_swapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class make_lexographically_smallest_value_array_by_swapping_numbers_with_diff_less_than_limit {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int m = nums.length;
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        List<Queue<Integer>> groups = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int grpIdx = 0;

        Queue<Integer> gp =  new LinkedList<>();
        gp.offer(sorted[0]);
        map.put(sorted[0], grpIdx);
        groups.add(gp);

        for (int i=1; i<m; i++) {
            if (Math.abs(sorted[i]-sorted[i-1]) <= limit) {
                gp.offer(sorted[i]);
            }
            else {
                gp = new LinkedList<>();
                gp.offer(sorted[i]);
                groups.add(gp);
                grpIdx++;
            }
            map.put(sorted[i], grpIdx);
        }

        int[] res = new int[m];
        for (int i=0; i<m; i++) {
            int groupIdx = map.get(nums[i]);
            res[i] = groups.get(groupIdx).poll();
        }
        return res;
    }    
}

/*
 * 2948. Make Lexicographically Smallest Array by Swapping Elements
https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/description/

You are given a 0-indexed array of positive integers nums and a positive integer limit.

In one operation, you can choose any two indices i and j and swap nums[i] and nums[j] if |nums[i] - nums[j]| <= limit.

Return the lexicographically smallest array that can be obtained by performing the operation any number of times.

An array a is lexicographically smaller than an array b if in the first position where a and b differ, array a has an element that is less than the corresponding element in b. For example, the array [2,10,3] is lexicographically smaller than the array [10,2,3] because they differ at index 0 and 2 < 10.

 

Example 1:

Input: nums = [1,5,3,9,8], limit = 2
Output: [1,3,5,8,9]
Explanation: Apply the operation 2 times:
- Swap nums[1] with nums[2]. The array becomes [1,3,5,9,8]
- Swap nums[3] with nums[4]. The array becomes [1,3,5,8,9]
We cannot obtain a lexicographically smaller array by applying any more operations.
Note that it may be possible to get the same result by doing different operations.
Example 2:

Input: nums = [1,7,6,18,2,1], limit = 3
Output: [1,6,7,18,1,2]
Explanation: Apply the operation 3 times:
- Swap nums[1] with nums[2]. The array becomes [1,6,7,18,2,1]
- Swap nums[0] with nums[4]. The array becomes [2,6,7,18,1,1]
- Swap nums[0] with nums[5]. The array becomes [1,6,7,18,1,2]
We cannot obtain a lexicographically smaller array by applying any more operations.
Example 3:

Input: nums = [1,7,28,19,10], limit = 3
Output: [1,7,28,19,10]
Explanation: [1,7,28,19,10] is the lexicographically smallest array we can obtain because we cannot apply the operation on any two indices.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
1 <= limit <= 109
 */