package recursion.lec3Hard;

public class _02_word_search {
    char[][] board;  
    int m, n;  
    boolean[][] used;  
    char[] word;

    public boolean exist(char[][] board, String word) {  
        this.board = board;  
        this.word = word.toCharArray();  
        m = board.length;
        n = board[0].length;
        used = new boolean[m][n];

        for (int r=0; r<m; r++) {
            for (int c=0; c<n; c++) {
               if (board[r][c] != this.word[0]) continue;
               if (dfs(r,c,0)) return true;
            }
        }
        return false;
    }

    boolean dfs(int r, int c, int k) {
        if (k == word.length) return true;
        if (r < 0 || r >= m || c < 0 || c >= n) return false;
        if (used[r][c]) return false;
        if (board[r][c] != word[k]) return false;

        k++;
        used[r][c] = true;
        if (dfs(r-1,c,k) || dfs(r,c-1,k) || dfs(r,c+1,k) || dfs(r+1,c,k)) {
            return true;
        }
        else {
            used[r][c] = false;
            return false;
        }
    }
}

/*
 
URL: https://leetcode.com/problems/word-search/description/

79. Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.
The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 
Example 1:
Input: board = [["A","B","C","E"],
                ["S","F","C","S"],
                ["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false

 
Constraints:

	m == board.length
	n = board[i].length
	1 <= m, n <= 6
	1 <= word.length <= 15
	board and word consists of only lowercase and uppercase English letters.
	Follow up: Could you use search pruning to make your solution faster with a larger board?
 */