class Solution {
    static int maxLen;
    static int minLen;
    static Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        maxLen = 0;
        minLen = Integer.MAX_VALUE;
        dp = new Boolean[s.length()];
        for(String word : wordDict){
            maxLen = Math.max(maxLen,word.length());
            minLen = Math.min(minLen,word.length());
        }
        return check(s,0,wordDict);
    }
    public boolean check(String s, int start,List<String> wordDict){
        if(s.length() == start) return true;
        if(s.length() - start < minLen)
            return false;
        if(dp[start] != null) return dp[start];
        for(int i = minLen;i<=maxLen && start+i<=s.length();i++){
            String curr = s.substring(start,start + i);
            if(!wordDict.contains(curr)) continue;
            if(check(s,start + i,wordDict)){
                return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}