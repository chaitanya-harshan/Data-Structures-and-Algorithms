package two_pointers.neetcode;

public class _05_trapping_rain_water {
    
    public int trap(int[] height) {
        int n = height.length;
        int leftMax = height[0], rightMax = height[n-1];
        int l = 0, r = n-1;

        int water = 0;
        while (l < r) { //
            if (leftMax <= rightMax) {
                water += leftMax - height[l];
                l++;
                leftMax = Math.max(leftMax, height[l]);
            }
            else {
                water += rightMax - height[r];
                r--;
                rightMax = Math.max(rightMax, height[r]);
            }
        }
        return water;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int leftMax = 0, rightMax = 0;
        int l = 0, r = n-1;

        int water = 0;
        while (l <= r) {
            if (leftMax <= rightMax) {
                leftMax = Math.max(leftMax, height[l]);
                water += leftMax - height[l];
                l++;
            }
            else {
                rightMax = Math.max(rightMax, height[r]);
                water += rightMax - height[r];
                r--;
            }
        }
        return water;
    }

    // easier
    public int trap3(int[] height) {
        int n = height.length;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        int water = 0;

        rightMax[n-1] = height[n-1];
        for (int i=n-2; i>=0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }

        leftMax[0] = height[0];
        for (int i=1; i<n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i-1]);

            water += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return water;
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