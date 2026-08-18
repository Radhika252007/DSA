class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<m;i++){
            dfs(grid,i,0,visited);
            dfs(grid,i,n-1,visited);
        }
        for(int i = 0;i<n;i++){
            dfs(grid,0,i,visited);
            dfs(grid,m-1,i,visited);
        }
        int count = 0;
        for(int i = 1;i<m-1;i++){
            for(int j = 1;j<n-1;j++){
                if(!visited[i][j] && grid[i][j] == 1) count++;
            }
        }
        return count;
    }
    public void dfs(int[][] grid, int i, int j, boolean[][] visited){
        if(i >= grid.length || i < 0 || j< 0 || j>=grid[0].length||grid[i][j] == 0 || visited[i][j])return;
        visited[i][j] = true;
        dfs(grid,i,j-1,visited);
        dfs(grid,i,j+1,visited);
        dfs(grid,i-1,j,visited);
        dfs(grid,i+1,j,visited);
    }
}