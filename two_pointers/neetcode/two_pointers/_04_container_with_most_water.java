package two_pointers.neetcode;

public class _04_container_with_most_water {

    /*
     * Thought Process:
     * 1. Problem Understanding:
     *    - We need to find two lines that form a container with maximum water
     *    - Water amount = width * height
     *    - Width = distance between lines (indices)
     *    - Height = minimum of the two line heights (water can't go higher)
     * 
     * 2. Two Pointer Approach:
     *    - Start with widest possible container (left=0, right=end)
     *    - Area = width * min(left height, right height)
     *    - To find larger area, we need to:
     *      a) Decrease width (moving pointers)
     *      b) Hope to find taller heights to compensate for decreased width
     *    - Strategy: Move the pointer with smaller height inward
     *      (because keeping the smaller height won't give us a better result)
     * 
     * Example: height = [1,8,6,2,5,4,8,3,7]
     * - Initial: l=0, r=8: area = 8 * min(1,7) = 8
     * - Move left (1 is smaller): l=1, r=8: area = 7 * min(8,7) = 49
     * - And so on...
     * 
     * Time: O(n), Space: O(1)
     * 
     *  * Key Insight:
    * - Moving inward always decreases width
    * - To get a larger area, we need to find taller heights
    * - Moving the pointer with larger height inward can never give us more area
    *   (because min height would stay same or decrease, and width decreases)
    * - Therefore, we always move the pointer with smaller height
     */
    public int maxArea(int[] height) {
        int area = 0, max = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            area = (r - l) * Math.min(height[l], height[r]);
            max = Math.max(max, area);
            // Move pointer with smaller height inward
            if (height[l] <= height[r]) {
                l++; 
            }else {
                r--;
            }
        }
        return max;
    }
}

/*
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * 
 * 
 * You are given an integer array height of length n. There are n vertical lines drawn such that 
 * the two endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the 
container contains the most water. Return the maximum amount of water a container can store.
Notice that you may not slant the container.

Example 1:
Input: height = [1,8,6,2,5,4,8,3,7]
Output: 49
Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
In this case, the max area of water (blue section) the container can contain is 49.

Example 2:
Input: height = [1,1]
Output: 1
 

Constraints:

n == height.length
2 <= n <= 105
0 <= height[i] <= 104

 */
