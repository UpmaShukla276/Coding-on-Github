
class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] ans = new int[m][n];

        Queue<int[]> q = new LinkedList<>();

        // Add kroo  all zero cells to queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    q.add(new int[]{i, j});
                } 
                else {
                    ans[i][j] = -1;
                }
            }
        }

        // Four directions
        int[][] dir = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            
            for (int[] d : dir) {

                int nr= row + d[0];
                int nc= col + d[1];

                if (nr >= 0 && nc >= 0 &&
                    nr < m && nc < n &&
                    ans[nr][nc] == -1) {

                    ans[nr][nc] = ans[row][col] + 1;

                    q.add(new int[]{nr, nc});
                }
            }
        }

        return ans;
    }
}
