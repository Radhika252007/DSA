class Solution {
    static int[][] directions= new int[][]{
        {1,0}, {0,1}, {-1,0}, {0,-1}
    };
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n]; 
        for(int i = 0;i<m;i++){
            dfs(heights,i,0,pacific);
        }
        for(int i = 0;i<n;i++){
            dfs(heights,0,i,pacific);
        }
        for(int i = 0;i<m;i++){
            dfs(heights,i,n-1,atlantic);
        }
        for(int i = 0;i<n;i++){
            dfs(heights,m-1,i,atlantic);
        }
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(List.of(i, j));
                }
            }
        }

        return ans;
    }
    public void dfs(int[][] heights,int i, int j, boolean[][] vis){
        vis[i][j] = true;
        for(int k = 0; k<4;k++){
            int adjR = i + directions[k][0];
            int adjC = j + directions[k][1];
            if (adjR >= 0 && adjR < heights.length &&
                adjC >= 0 && adjC < heights[0].length &&
                !vis[adjR][adjC] &&
                heights[adjR][adjC] >= heights[i][j]) {

                dfs(heights, adjR, adjC, vis);
            }
        }
    }
    
}