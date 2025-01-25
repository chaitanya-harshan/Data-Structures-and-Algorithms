package arrays.sums & subArrays;

public class longest_subArr_with_max_AND {
    
    // Question is basically "Find the Longest Consecutive subarray with the max element"
    public int longestSubarray(int[] nums) {
        // https://youtu.be/N8lRlRWA_1Q - neetcode

        // int max = Arrays.stream(nums).max().getAsInt();
        // int maxLen = 0, len = 0;
        // for (int num: nums) {
        //     if (num == max) len++;
        //     else len = 0; // 12-33-21-333-2121
        //     // we don't care about number apart from 3 casue we know 3 is the max
        //     // and we need len of the subarr of max And.
        //     // here after traversing the initial 3's we make len=0 untill the next
        //     // set of 3's which will make len=3 > maxLen(=2)
        //     maxLen = Math.max(maxLen, len);
        // }
        // return maxLen;

        // # Without Using 2 passes and directly doing it in 1 pass.

        // If num < cur_max --> num & cur_max is < cur_max
        // If num = cur_max --> num & cur_max is == cur_max
        // If num > cur_max --> num & cur_max is < num (num will become the new cur_max)
        int len = 0, maxLen = 0;
        int curMax = 0;
        for (int num: nums) {
            if (num < curMax) {
                len = 0;
            }
            else if (num == curMax) {
                len++;
            }
            else {// num > curMax
                len = 1;
                maxLen = 0; // or 1
                curMax = num;
            }
            maxLen = Math.max(maxLen, len);
        }
        return maxLen;
    }
}
