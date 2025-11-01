package graphs.bfs_dfs;

import java.util.*;

public class _04_flood_fill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image; // if equal then we wil visit the same nodes
        // again and again causing TLE (unless we use a visited array)
        dfs(image, sr, sc, image[sr][sc], color);
        return image;
    }

    void dfs(int[][] image, int i, int j, int og, int color) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length) return;
        if (image[i][j] != og) return;

        image[i][j] = color;

        dfs(image, i-1, j, og, color);
        dfs(image, i+1, j, og, color);
        dfs(image, i, j-1, og, color);
        dfs(image, i, j+1, og, color);
    }

// BFS ==============================================================================================
    public int[][] floodFill1(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image; // if equal then we wil visit the same nodes
        // again and again causing TLE (unless we use a visited array)

        int m = image.length, n = image[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, -1, 0, 1};
        int og = image[sr][sc];

        while (!q.isEmpty()) {
            int row = q.peek()[0];
            int col = q.poll()[1];

            image[row][col] = color;

            for (int i=0; i<4; i++) {
                int r = row + dr[i];
                int c = col + dc[i];
                if (r < 0 || r >= m || c < 0 || c >= n) continue;

                if (image[r][c] == og) q.offer(new int[]{r,c});
            }
        }
        return image;
    }
}

/*
 * URL: https://leetcode.com/problems/flood-fill/description/

733. Flood Fill

You are given an image represented by an m x n grid of integers image, where image[i][j] 
represents the pixel value of the image. You are also given three integers sr, sc, and color. 
Your task is to perform a flood fill on the image starting from the pixel image[sr][sc].

To perform a flood fill:
Begin with the starting pixel and change its color to color.
Perform the same process for each pixel that is directly adjacent (pixels that share a side with the 
original pixel, either horizontally or vertically) and shares the same color as the starting pixel.
Keep repeating this process by checking neighboring pixels of the updated pixels and modifying their color 
if it matches the original color of the starting pixel.
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