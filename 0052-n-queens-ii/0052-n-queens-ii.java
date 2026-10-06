class Solution {
    public int totalNQueens(int n) {

        char board[][] = new char[n][n];

        // Fill board with '.'
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }

        return solve(board, 0, n);
    }

    public int solve(char[][] board, int row, int n){

        // All queens are placed
        if(row == n){
            return 1;
        }

        int count = 0;

        // Try every column
        for(int col = 0; col < n; col++){

            if(isSafe(board, row, col, n)){

                // Place queen
                board[row][col] = 'Q';

                // Go to next row
                count += solve(board, row + 1, n);

                // Backtrack
                board[row][col] = '.';
            }
        }

        return count;
    }

    public boolean isSafe(char[][] board, int row, int col, int n){

        // Check column
        for(int i = 0; i < row; i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }

        // Check upper-left diagonal
        int i = row - 1;
        int j = col - 1;

        while(i >= 0 && j >= 0){

            if(board[i][j] == 'Q'){
                return false;
            }

            i--;
            j--;
        }

        // Check upper-right diagonal
        i = row - 1;
        j = col + 1;

        while(i >= 0 && j < n){

            if(board[i][j] == 'Q'){
                return false;
            }

            i--;
            j++;
        }

        return true;
    }
}

  