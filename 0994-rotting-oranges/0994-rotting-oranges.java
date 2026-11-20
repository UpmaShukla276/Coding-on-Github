
class Solution {

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        int fresh = 0;

        // Find all rotten and fresh oranges
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {

                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        // Four directions
        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        // BFS
        while(!q.isEmpty() && fresh > 0) {

            int size = q.size();

            for(int i = 0; i < size; i++) {

                int[] current = q.poll();

                int row = current[0];
                int col = current[1];

                for(int[] dir : directions) {

                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow >= 0 && newCol >= 0 &&
                       newRow < rows && newCol < cols &&
                       grid[newRow][newCol] == 1) {

                        grid[newRow][newCol] = 2;

                        fresh--;

                        q.add(new int[]{newRow, newCol});
                    }
                }
            }

            minutes++;
        }

        if(fresh > 0) {
            return -1;
        }

        return minutes;
    }
}
