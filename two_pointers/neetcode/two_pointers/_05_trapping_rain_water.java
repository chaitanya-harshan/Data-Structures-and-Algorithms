package two_pointers.neetcode;

public class _05_trapping_rain_water {
    
    public int trap(int[] height) {
        // Tip: maks sure the leftMx & rightMx of the curr i lied on the curr i 
        // instad of calling max[i+1] or mx[i-1]
        int n = height.length;
        int[] rightMax = new int[n];
        rightMax[n-1] = height[n-1];
        for (int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        int water = 0;
        int leftMax = height[0];
        for (int i=1; i<n-1; i++) {
            leftMax = Math.max(leftMax, height[i]);
            water += Math.min(leftMax, rightMax[i]) - height[i];
        }
        return water;
        
        // This gives very bad time complexity. ig because of math.mx(,0)
        // int Totalwater = 0;
        // int leftMax = height[0];
        // for (int i = 1; i < n-1; i++) {
        //     int water = Math.min(leftMax, rightMax[i+1]) - height[i];
        //     Totalwater += Math.max(water, 0);
        //     leftMax = Math.max(leftMax, height[i]);
        // }
        // return Totalwater;

    }
}

/*
 * 42. Trapping Rain Water
https://leetcode.com/problems/trapping-rain-water/description/

Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it can trap after raining.

 

Example 1:
Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
In this case, 6 units of rain water (blue section) are being trapped.

Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105
 */