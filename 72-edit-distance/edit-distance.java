class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int m = word1.length()-1;
        int n = word2.length()-1;
        dp = new int[m+1][n+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return countOp(word1,word2,m,n);
    }
    public int countOp(String word1, String word2, int i, int j){
        if(i < 0) return j + 1;
        if(j < 0) return i + 1;
        if(dp[i][j]!= -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = countOp(word1, word2, i-1, j-1);
        }
        else{
        int replace = 1 + countOp(word1,word2,i-1,j-1);
        int insert = 1 + countOp(word1, word2,i, j-1);
        int remove = 1 + countOp(word1, word2, i-1, j);
        dp[i][j] = Math.min(replace, Math.min(insert, remove));
        }
        return dp[i][j];
    }
}