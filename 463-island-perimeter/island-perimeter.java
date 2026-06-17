class Solution {

    public int islandPerimeter(int[][] grid) {
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    return getPerimeter(grid,i,j);
                }
            }
        }
        return 0;
    }
    public int getPerimeter(int[][] grid, int i, int j){
        if(i>=grid.length || i<0 || j>= grid[0].length || j<0 || grid[i][j] == 0) return 1;
        if(grid[i][j] == 2) return 0;
        grid[i][j] = 2;
        return getPerimeter(grid,i,j+1) + getPerimeter(grid,i,j-1)+getPerimeter(grid,i+1,j)+ getPerimeter(grid,i-1,j);
        
    }

}