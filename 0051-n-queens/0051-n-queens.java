class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for(int i=0;i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        solve(board, 0, n, ans);
        return ans;
    }
    public void solve(char[][] board, int row, int n, List<List<String>> ans){
        if(row==n){
            List<String> current = new ArrayList<>();
            for(int i=0; i<n; i++){
                current.add(new String(board[i]));
            }
            ans.add(current);
            return;
        }
        for(int col = 0; col<n;col++){
            if(isSafe(board, row, col, n)){
                board[row][col] = 'Q';

                solve(board,row+1,n,ans);
                
                board[row][col] = '.';
            }
        }
    }
    public boolean isSafe(char[][] board, int row, int col, int n){
        for(int i=0; i<row; i++){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        //diagonals
        int i=row-1;
        int j = col-1;
        while(i>=0 && j>=0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        i=row-1;
        j=col+1;
        while(i>=0 && j<n){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }
}