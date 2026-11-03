class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0] == 1) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                 if(obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if(i == 0 && j==0) continue;
                int nextRow = -1;
                int nextCol = -1;
                if(i-1 >= 0) nextRow = i-1;
                if(j-1 >= 0) nextCol = j-1;
                if(nextRow != -1) dp[i][j] += dp[nextRow][j];
                if(nextCol != -1) dp[i][j] += dp[i][nextCol];
            }
        }
        return dp[m-1][n-1];
    }
}