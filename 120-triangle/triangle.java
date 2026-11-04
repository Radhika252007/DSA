class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] dp = new int[m][m];
        dp[0][0] = triangle.get(0).get(0);
        for(int i = 1;i<m;i++){
            dp[i][0] = triangle.get(i).get(0) + dp[i-1][0];
            for(int j = 1;j<i;j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i-1][j], dp[i-1][j-1]);
            }
            dp[i][i] = triangle.get(i).get(i) + dp[i-1][i-1];
        }
         int ans = Integer.MAX_VALUE;

        for(int j = 0; j < m; j++) {
            ans = Math.min(ans, dp[m-1][j]);
        }

        return ans;
    }

}