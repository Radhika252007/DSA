class Solution {
    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int start = 0;
        int maxLen = 1;
        int end = 0;
        for(int i = 0;i<s.length();i++){
            dp[i][i] = true;
            for(int j = 0;j<i;j++){
                if((s.charAt(i) == s.charAt(j)) && (i - j <= 2 || dp[j+1][i-1])){
                    dp[j][i] = true;
                if(maxLen < i - j + 1){
                    start = j;
                    end = i;
                    maxLen = i - j + 1;
                }
                }
            }
        }
        return s.substring(start, end + 1);
    }
}