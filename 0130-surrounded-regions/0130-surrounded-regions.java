
class Solution {

    public void solve(char[][] board) {

        int m = board.length;
        int n = board[0].length;

        // Step 1: Traverse the first and last columns
        for (int i = 0; i < m; i++) {

            // If first column contains O, start DFS
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }

            // If last column contains O, start DFS
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        // Step 2: Traverse the first and last rows
        for (int j = 0; j < n; j++) {

            // If first row contains O, start DFS
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }

            // If last row contains O, start DFS
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        // Step 3: Traverse the entire matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Remaining O cells are surrounded, so change them to X
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }

                // Restore safe cells back to O
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    // DFS function to mark all boundary-connected O cells as safe
    public void dfs(char[][] board, int row, int col) {

        // Base condition:
        // Stop if outside the matrix or current cell is not O
        if (row < 0 || col < 0 ||
            row >= board.length ||
            col >= board[0].length ||
            board[row][col] != 'O') {

            return;
        }

        // Mark current O as safe and visited
        board[row][col] = '#';

        // Explore the four neighboring directions

        dfs(board, row + 1, col); // Down
        dfs(board, row - 1, col); // Up
        dfs(board, row, col + 1); // Right
        dfs(board, row, col - 1); // Left
    }
}
