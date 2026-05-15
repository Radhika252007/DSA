class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int c = 0;
        for(int i = 0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == '1'){
                    checkPath(grid,i,j);
                    c++;
                }
            }
        }
        return c;
    }
    public void checkPath(char[][] grid,int i, int j){
        if(i >= grid.length || i <0 || j >= grid[0].length || j < 0 || grid[i][j]!='1') return;
        grid[i][j] = '0';
        checkPath(grid,i-1,j);
        checkPath(grid,i+1,j);
        checkPath(grid,i,j+1);
        checkPath(grid,i,j-1);
    }
}