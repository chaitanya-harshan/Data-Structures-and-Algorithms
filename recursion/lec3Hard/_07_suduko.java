package recursion.lec3Hard;

/**
 * _06_suduko
 */
public class _07_suduko {
    char[][] board;

    public void solveSudoku(char[][] board) {
        this.board = board;
        solve(0,0);
    }

    boolean solve(int r,int c) {
        if (r == 9) return true;

        int nextRow = c == 8 ? r+1 : r;
        int nextCol = c == 8 ? 0 : c+1;

        if (board[r][c] == '.') {
            for (char ch='1'; ch<='9'; ch++) {
                if (isValid(ch, r, c)) {
                    board[r][c] = ch;
                    if (solve(nextRow, nextCol)) return true;
                    board[r][c] = '.';
                }
            }
            return false;
        }
        else return solve(nextRow, nextCol); 
    }

    boolean isValid(char c, int row, int col) {
        for (int i=0; i<board.length; i++) {
            if (board[i][col] == c) return false;
            if (board[row][i] == c) return false;
            if (board[3*(row/3) + i/3][3*(col/3) + i % 3] == c) return false;
        }
        return true;
    }
}

/*
https://leetcode.com/problems/sudoku-solver/description/
https://youtu.be/FWAIf_EVUKE?list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma

 * A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Input: board = 
[[5 3 .   . 7 .    . . .] 
[6 . .    1 9 5    . . .] 
[. 9 8    . . .    . 6 .] 

[8 . .    . 6 .    . . 3] 
[4 . .    8 . 3    . . 1] 
[7 . .    . 2 .    . . 6] 

[. 6 .    . . .    2 8 .] 
[. . .    4 1 9    . . 5] 
[. . .    . 8 .    . 7 9]]

Output: 
[[5 3 4    6 7 8    9 1 2] 
[6 7 2    1 9 5    3 4 8] 
[1 9 8    3 4 2    5 6 7] 

[8 5 9    7 6 1    4 2 3] 
[4 2 6    8 5 3    7 9 1] 
[7 1 3    9 2 4    8 5 6] 

[9 6 1    5 3 7    2 8 4] 
[2 8 7    4 1 9    6 3 5] 
[3 4 5    2 8 6    1 7 9]]
 */