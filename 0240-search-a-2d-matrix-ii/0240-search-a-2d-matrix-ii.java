class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
            // for rows
        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = 0;
        int col = cols - 1;

        while (row < rows && col >= 0) {

            if (matrix[row][col] == target) {
                return true;
            }

            else if (matrix[row][col] > target) {
                col--;        // Move left heheee
            }

            else {
                row++;        // Move down kro betaaa
            }
        }

        return false;
    }
}