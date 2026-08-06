class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                int curr = mat[i][j];

                // four condititionsss
                if (i > 0 && mat[i - 1][j] >= curr) continue;

                
                if (i < n - 1 && mat[i + 1][j] >= curr) continue;

                
                if (j > 0 && mat[i][j - 1] >= curr) continue;

               
                if (j < m - 1 && mat[i][j + 1] >= curr) continue;

                
                return new int[]{i, j};
            }
        }
        return new int[]{-1, -1}; 
    }
}
