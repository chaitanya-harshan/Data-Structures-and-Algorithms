package _concepts.hashing_and_counting;

import java.util.HashMap;

public class count_bad_pairs {

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> mapi = new HashMap<>(); // count of `i - nums[i]`

        for (int i=0; i<n; i++) {
            int xi = i - nums[i];
            mapi.put(xi, mapi.getOrDefault(xi,0)+1);
        }
        long goodPairs = 0;
        for (int cnt: mapi.values()) {
            goodPairs += (long)cnt*(cnt-1) / 2; // nCp -> [cnt]C[2]
        }
        long totalPairs = (long)n*(n-1) / 2; // nCp -> [n]C[2]
        
        return totalPairs - goodPairs;
    }
}

/*
This solution counts the number of bad pairs in the given array nums.

## Problem Analysis:
A pair of indices (i, j) is a "good pair" if:
    j - i == nums[j] - nums[i]
Rearranging this:
    j - nums[j] == i - nums[i]
Let `X_i = i - nums[i]`. Then the pair (i, j) is "good" if:
    X_i == X_j

## Approach:
1. Compute `X_i = i - nums[i]` for each index i and count the occurrences using a HashMap.
   The keys of the HashMap store the computed values `X_i`, and the values store their counts.

2. Counting Good Pairs:
   If a value `X` appears `count(X)` times, the number of good pairs for this value is:
       count(X) * (count(X) - 1) / 2
   This is the combination formula for choosing 2 indices out of `count(X)` indices.

3. Counting Bad Pairs:
   Total pairs in an array of length n is:
       n * (n - 1) / 2
   Bad pairs are simply:
       total pairs - good pairs

## Complexity Analysis:
- Time Complexity: O(n) because we traverse the array and use HashMap operations (O(1) average).
- Space Complexity: O(n) for storing the HashMap.

## Important Note:
To handle large test cases, casting `n` to `long` is necessary to avoid integer overflow 
in expressions like `n * (n - 1) / 2`.
*/



/*
 * 2364. Count Number of Bad Pairs
https://leetcode.com/problems/count-number-of-bad-pairs/description/

You are given a 0-indexed integer array nums. A pair of indices (i, j) is a bad pair if i < j and j - i != nums[j] - nums[i].

Return the total number of bad pairs in nums.

 

Example 1:

Input: nums = [4,1,3,3]
Output: 5
Explanation: The pair (0, 1) is a bad pair since 1 - 0 != 1 - 4.
The pair (0, 2) is a bad pair since 2 - 0 != 3 - 4, 2 != -1.
The pair (0, 3) is a bad pair since 3 - 0 != 3 - 4, 3 != -1.
The pair (1, 2) is a bad pair since 2 - 1 != 3 - 1, 1 != 2.
The pair (2, 3) is a bad pair since 3 - 2 != 3 - 3, 1 != 0.
There are a total of 5 bad pairs, so we return 5.
Example 2:

Input: nums = [1,2,3,4,5]
Output: 0
Explanation: There are no bad pairs.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 109
 */