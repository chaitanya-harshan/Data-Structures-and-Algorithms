import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

public class _03_longest_consecutive_subsequence {
    
    public int longestConsecutive(int[] nums) {
        // Hashset is much faster then set
        HashSet<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet :: new));
        // Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        // HashSet<Integer> set = new HashSet<>();
        // for (int num : nums) {
        //     set.add(num);
        // }

        //   1 2 3 4     100     200
        int MaxLen = 0;
        for (int num : nums) {
            // first finding the first num of the sequence else continuing
            if (!set.contains(num-1)) {
                int length = 1;
                // now checking if the next num of the sequence exists
                while (set.contains(++num)) length++;
                MaxLen = Math.max(MaxLen, length);
            }
        }
        return MaxLen;
    }
}

/*
 * 28. Longest Consecutive Sequence
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.

Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
 

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
