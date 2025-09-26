package graphs;

public class _04_flood_fill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // Get the original color of the starting pixel.
        int startColor = image[sr][sc];

        // If the starting pixel already has the target color, no work is needed.
        // This check also prevents an infinite recursion loop if startColor == color.
        if (startColor != color) {
            dfs(image, sr, sc, startColor, color);
        }

        return image;
    }

    private void dfs(int[][] image, int r, int c, int startColor, int newColor) {
        // --- Base Cases for stopping the recursion ---

        // 1. Check for out of bounds.
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length) {
            return;
        }

        // 2. Check if the current pixel is not the color we want to replace.
        if (image[r][c] != startColor) {
            return;
        }

        // --- Action ---
        // Change the color of the current pixel.
        image[r][c] = newColor;

        // --- Recursive Calls for 4-directional neighbors ---
        dfs(image, r + 1, c, startColor, newColor); // Down
        dfs(image, r - 1, c, startColor, newColor); // Up
        dfs(image, r, c + 1, startColor, newColor); // Right
        dfs(image, r, c - 1, startColor, newColor); // Left
    }
}

/*
 * URL: https://leetcode.com/problems/flood-fill/description/

733. Flood Fill

You are given an image represented by an m x n grid of integers image, where image[i][j] represents the pixel value of the image. You are also given three integers sr, sc, and color. Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].
To perform a flood fill:
Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color if it matches the original color of the starting pixel.
The process stops when there are no more adjacent pixels of the original color to update.
Return the modified image after performing the flood fill.

 
Example 1:
Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, color = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation:
From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
Note the bottom corner is not colored 2, because it is not horizontally or vertically connected to the starting pixel.
Example 2:
Input: image = [[0,0,0],[0,0,0]], sr = 0, sc = 0, color = 0
Output: [[0,0,0],[0,0,0]]
Explanation:
The starting pixel is already colored with 0, which is the same as the target color. Therefore, no changes are made to the image.

 
Constraints:

	m == image.length
	n == image[i].length
	1 <= m, n <= 50
	0 <= image[i][j], color < 216
	0 <= sr < m
	0 <= sc < n
 */