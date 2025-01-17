package bit_manipulation.extras;

public class xor_of_all_pairs_of_2_arrs {
    ublic int xorAllNums(int[] nums1, int[] nums2) {
        int res = 0;
        if (nums2.length % 2 == 1) {
            for (int ni: nums1) res ^= ni;
        }
        // int mXOR = 0; 
        // for (int mi: nums2) mXOR ^= mi;
        // if (nums1.length % 2 == 1) res ^= mXOR;

        if (nums1.length % 2 == 1) {
            for (int mi: nums2) res ^= mi;
        }
        return res;
    }
}

// [(n1^m1) ^ (n1^m2) ^ (n1^m3) ^ (n1^m4)] ^
// [(n2^m2) ^ (n2^m2) ^ (n2^m3) ^ (n2^m4)] ^
// [(n3^m3) ^ (n3^m2) ^ (n3^m3) ^ (n3^m4)]

// n1^n2^n3 ^ [ (m1^m2^m3^m4) repeat -> n.len % 2]

/*
 * 2425. Bitwise XOR of All Pairings
https://leetcode.com/problems/bitwise-xor-of-all-pairings/description/

You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).

Return the bitwise XOR of all integers in nums3.

 

Example 1:

Input: nums1 = [2,1,3], nums2 = [10,2,5,0]
Output: 13
Explanation:
A possible nums3 array is [8,0,7,2,11,3,4,1,9,1,6,3].
The bitwise XOR of all these numbers is 13, so we return 13.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 0
Explanation:
All possible pairs of bitwise XORs are nums1[0] ^ nums2[0], nums1[0] ^ nums2[1], nums1[1] ^ nums2[0],
and nums1[1] ^ nums2[1].
Thus, one possible nums3 array is [2,5,1,6].
2 ^ 5 ^ 1 ^ 6 = 0, so we return 0.
 

Constraints:

1 <= nums1.length, nums2.length <= 105
0 <= nums1[i], nums2[j] <= 109
 */
