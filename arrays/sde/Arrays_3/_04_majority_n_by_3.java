package arrays.sde.Arrays_3;

import java.util.ArrayList;
import java.util.List;

public class _04_majority_n_by_3 {

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int a = Integer.MIN_VALUE, b = Integer.MIN_VALUE;
        int c1 = 0, c2 = 0;

        for (int i : nums) {
            if ((a == i) || (c1 == 0 && i != b)) { // case where c1 = 0 but c2 == i
                a = i;
                c1++;
            } else if (c2 == 0 || b == i) {
                b = i;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        List<Integer> list = new ArrayList<>();
        c1 = 0;
        c2 = 0;
        for (int i : nums) {
            if (i == a) {
                c1++; 
            }else if (i == b) {
                c2++;
            }
        }
        if (c1 > n / 3) {
            list.add(a);
        }
        if (c2 > n / 3) {
            list.add(b);
        }
        return list;
    }

// Assuming the worst case where there is only one element which is the majority element 
// and the rest are different elements. The first non-majority element will become the second 
// element, and the third non-majority element will cause a reduction in the first and the second.
// The third element not being equal will cause a reduction in the first and the second element. 
// So therefore, what's happening really is the one instance of element one is causing the 
// cancellation of three elements in the array.
// If we assume there is a majority element, which has a count of n/3 + 1 or more. 
// Then, n/3 instances of the first element will cancel out n elements in the total array. 
// But we have more then n/3 instances of element one, so it's impossible for the majority 
// element (which is assumed to be element one) to be nullified.
// ------------------GPT rewrite------------------
// Worst case: assume there is exactly one majority element and all others are different.
// At first, the majority becomes a candidate, then each new distinct element either
// fills the second slot or triggers a cancellation (decrement of both counts).
// Every cancellation step removes 3 elements from consideration: the outsider itself
// plus one count of each candidate.
// If the majority element appears more than n/3 times, then at most n/3 of its
// occurrences can be cancelled out in this way. Since it starts with > n/3 copies,
// it can never be fully eliminated and will always survive as a candidate.
}

/*
https://leetcode.com/problems/majority-element-ii/description/
https://youtu.be/vwZj1K0e9U8

 * 229. Majority Element II
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Input: nums = [3,2,3]
Output: [3]

Input: nums = [1]
Output: [1]

Input: nums = [1,2]
Output: [1,2]
 */
// for trail
// 4444 4123 5678
// aaaaaa abcdef ghijkl
// 1231 4516 7189

