class Solution {
    int[][] dp;
    public int numDistinct(String s, String t) {
        dp = new int[s.length()][t.length()];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return subsequence(s,t,s.length()-1,t.length()-1);
    }
    public int subsequence(String s, String t, int i, int j){
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int count = 0;
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = subsequence(s,t,i-1,j-1) + subsequence(s,t,i-1,j);
        }
        else{
            dp[i][j] = subsequence(s,t,i-1,j);
        }
        return dp[i][j];

}
}