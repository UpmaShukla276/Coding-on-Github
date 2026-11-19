class Solution {

    public void dfs(int[][] image, int row, int col, int OriginalColor, int color){

        if(row<0 || col<0 || row>=image.length || col>= image[0].length || image[row][col] != OriginalColor){
            return;
        }

        image[row][col] = color;

        dfs(image, row+1,col,OriginalColor, color);
        dfs(image, row-1,col,OriginalColor, color);
        dfs(image, row,col+1,OriginalColor, color);
        dfs(image, row,col-1,OriginalColor, color);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int OriginalColor = image[sr][sc];

        if(OriginalColor == color){
            return image;
        }
        dfs(image, sr, sc,OriginalColor,color);
        return image;
    }
}