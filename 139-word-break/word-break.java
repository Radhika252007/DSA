class Solution {
    int minLen;
    int maxLen;
    Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp = new Boolean[s.length()];
        minLen = s.length();
        maxLen = 0;
        for(String word : wordDict){
            minLen = Math.min(minLen, word.length());
            maxLen = Math.max(maxLen, word.length());
        }
        return check(s, 0, wordDict);
    }
    public boolean check(String s, int start, List<String> wordDict){
        if(start == s.length()) return true;
        if(minLen > s.length() - start) return false;
        if(dp[start] != null) return dp[start];
        for(int i = minLen;i<=maxLen && start + i <= s.length();i++){
            String curr = s.substring(start, start + i);
            if(!wordDict.contains(curr)) continue;
            if(check(s, start + i, wordDict)){
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}