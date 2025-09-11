import java.util.ArrayList;
import java.util.List;

public class _05_min_path_sum_triangle_grid {
    
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> prev = triangle.getLast();
        // If you're wondering, shouldn't we have a zero array list? You need to understand that when the triangle has a height of 1, it means there is only one element. So you could just return the first element.

        for (int i=triangle.size()-2; i>=0; i--) {
            List<Integer> row = new ArrayList<>();
            
            for (int j=0; j<=i; j++) {
                int min = Math.min(prev.get(j), prev.get(j+1));
                row.add(triangle.get(i).get(j) + min);
            }
            prev = row;
        }
        return prev.get(0);
    }
}

/*
 * 120. Triangle
 * https://leetcode.com/problems/triangle/description/
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.

 

Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 .
 */
