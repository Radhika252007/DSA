class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp = new int[m+1][n+1];
        for(int i = 0;i<=m;i++){
            dp[i][0] = i;
        }
        for(int j = 0;j<=n;j++){
            dp[0][j] = j;
        }
        for(int i = 1;i<=m;i++){
            for(int j = 1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.min(1 + dp[i-1][j-1], Math.min(dp[i][j-1] + 1, dp[i-1][j] + 1));
                }
            }
        }
        return dp[m][n];

        // for(int[] arr : dp){
        //     Arrays.fill(arr,-1);
        // }
        // return countOp(word1,word2,m,n);
    }
    // public int countOp(String word1, String word2, int i, int j){
    //     if(i < 0) return j + 1;
    //     if(j < 0) return i + 1;
    //     if(dp[i][j]!= -1) return dp[i][j];
    //     if(word1.charAt(i) == word2.charAt(j)) {
    //         dp[i][j] = countOp(word1, word2, i-1, j-1);
    //     }
    //     else{
    //     int replace = 1 + countOp(word1,word2,i-1,j-1);
    //     int insert = 1 + countOp(word1, word2,i, j-1);
    //     int remove = 1 + countOp(word1, word2, i-1, j);
    //     dp[i][j] = Math.min(replace, Math.min(insert, remove));
    //     }
    //     return dp[i][j];
    // }
}