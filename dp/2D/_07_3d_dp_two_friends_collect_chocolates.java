import java.util.Arrays;

public class _07_3d_dp_two_friends_collect_chocolates {
    
    public static void main(String[] args) {
        int[][] grid = {{3,1,1},{2,5,1},{1,5,5},{2,1,1}};
        System.out.println(solve(4, 3, grid));
        System.out.println(maximumChocolates(4, 3, grid));
    }
    
    // Here MEMOIZATION is better than TABULATION becasue u dont need to calculate all sub problems
    // https://www.geeksforgeeks.org/problems/chocolates-pickup/1 - gfg

    // tabulation  (below there is code for memoization)
    public static int solve(int n, int m, int grid[][]) {
        int[][] prev = new int[m][m];
        
        for (int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                if (i==j) prev[i][j] = grid[n-1][i];
                else prev[i][j] = grid[n-1][i] + grid[n-1][j];
            }
        }
        
        for (int i=n-2; i>=0; i--) {
            int[][] dp = new int[m][m];
            
            for (int m1 = 0; m1 < m; m1++) {
                for (int m2 = 0; m2 < m; m2++) {
                    int max = 0;
                    
                    for (int j1 = m1-1; j1 <= m1+1; j1++) {
                        for (int j2 = m2-1; j2 <= m2+1; j2++) {
                            if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) continue;
                            max = Math.max(prev[j1][j2], max);
                        }
                    }
                    
                    dp[m1][m2] += max;
                    if (m1 == m2) dp[m1][m2] += grid[i][m1];
                    else dp[m1][m2] += grid[i][m1] + grid[i][m2];
                }
            }
            
            prev = dp;
        }
        return prev[0][m-1];
    }

// __________________________________________________________________________________________________________________________________________
    // Memoization - easier for this problem
    // https://www.naukri.com/code360/problems/ninja-and-his-friends_3125885
    public static int maximumChocolates(int n, int m, int[][] grid) {
		// Write your code here.
		int[][][] dp = new int[n][m][m];
		Arrays.stream(dp).forEach(slice -> Arrays.stream(slice).forEach(row -> Arrays.fill(row,-1)));

		return backtrack(0, 0, m-1, grid, dp, n, m);
	}

	static int backtrack(int i, int j1, int j2, int[][] grid, int[][][] dp, int n, int m) {
		if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
			return Integer.MIN_VALUE;

		if (i == n-1) {
			if (j1 == j2) return grid[i][j1];
			else return grid[i][j1] + grid[i][j2];
		}

		if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

		int max = Integer.MIN_VALUE;
		for (int da = -1; da <= 1; da++) {
			for (int db = -1; db <= 1; db++) {				
				max = Math.max(max, backtrack(i+1, j1+da, j2+db, grid, dp, n, m));
			}
		}
		if (j1 == j2) max += grid[i][j1];
		else max += grid[i][j1] + grid[i][j2];

		return dp[i][j1][j2] = max;
	}
}

// ************************************************* IF YOUR'E BREAKING YOUR HEAD*******************
// if eg: nx3x3
// nx3x3  becasue no. of directions each can take.
// for some i let's say 'A' is in a column and 'B' is in b column then a slice has all the postions
// of a & b such that (a-1,a,a+1) x (b-1,b,b+1) => 3x3
// for a dp[i][a][b] it'll tell the max value u can get if you go from (i-1)
// to [i][a][b]
// _______IMPORTANT TO READ AFTER YOU READ THE ABOVE____
// but if we have like 10 columns then 'A' can be 3rd and 'B' can in 7 then u need [2,3,4] & [6,7,8]
// therfore we need to store all the instance/paths of [0-cols] x [0-cols] for every slice or 'i' becasue
//  some paths need some and other paths needs other cols which might not overlap in the columns required

// _______ BOTH ARE MOVING CONTINOUS___________
// you can't think that first u will find the max of A then u will find B because while finding max from a 'i' 
// we can again get a ja=jb which means sometimes u should skip local maxima ans choose diff path to get the global maxima.  
// If you're thinking if they both are in the same j then from then onwards they both will have same 
// max values from there but NO. the algo will try all the 3x3 cases from that 'i' and then from then 
// the path where they take all the same directions 
// (both have same path/matrix_instances => nxt direction -> {j1+da == j2+db}) will not be max 
// and other paths will have max path as in this path it's always one of the robot gets 0 chocolates.

// TO BE CLEAR: Here path means the instance of the 3D matrix wich means combination of both paths.
// The algo doesnt care about who gets how much, it only cares about the total max sum so therefore when both
// start from same j then there's no argument of what if [t=takes, nt = not takes] once At,Bnt : Ant,bt etc to equalize
// ****************************************************************************************************



/*
 * You are given an n rows and m cols matrix grid representing a field of chocolates where grid[i][j] represents 
 * the number of chocolates that you can collect from the (i, j) cell.

You have two robots that can collect chocolates for you:

Robot #1 is located at the top-left corner (0, 0), and
Robot #2 is located at the top-right corner (0, cols - 1).
Return the maximum number of chocolates collection using both robots by following the rules below:

From a cell (i, j), robots can move to cell (i + 1, j - 1), (i + 1, j), or (i + 1, j + 1).
When any robot passes through a cell, It picks up all chocolates, and the cell becomes an empty cell.
When both robots stay in the same cell, only one takes the chocolates.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in grid.
Example:

Input:
n = 4, m = 3
grid = [[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24

Explanation:
Path of robot #1 and #2 are described in color green and blue respectively. 
Chocolates taken by Robot #1, (3 + 2 + 5 + 2) = 12. 
Chocolates taken by Robot #2, (1 + 5 + 5 + 1) = 12. 
Total of Chocolates: 12 + 12 = 24.
 */