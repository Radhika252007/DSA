class Solution {
    boolean[][] visited;
    int[] dr = new int[]{1,-1,0,0};
    int[] dc = new int[]{0,0,1,-1};
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited= new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(!visited[i][j]){
                    if(dfs(grid,i,j,-1,-1)) return true;
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] grid, int i, int j, int lastI, int lastJ){
        visited[i][j] = true;
        boolean ans = false;
        for(int k = 0;k<4;k++){
            int nextR = i + dr[k];
            int nextC = j + dc[k];
            if(nextR < 0 || nextR >= grid.length || nextC < 0 || nextC >= grid[0].length) continue;
            if(nextR == lastI && nextC == lastJ) continue;
            if(grid[nextR][nextC] != grid[i][j]) continue;
            if(visited[nextR][nextC]) return true;
            if(dfs(grid,nextR, nextC, i, j)) return true;
        }
        return ans;
    }
}