class Solution {
    List<String>[] dp;
    Set<String> dict;
    public List<String> wordBreak(String s, List<String> wordDict) {
        dp = new ArrayList[s.length() + 1];
        dict = new HashSet<>(wordDict);
        return dfs(s,0);
    }
    public List<String> dfs(String s, int start){
        if(s.length() == start){
            return new ArrayList<>(List.of(""));
        }
        if(dp[start] != null) return dp[start];
        List<String> res = new ArrayList<>();
        for(int end = start + 1;end <= s.length();end++){
            String curr = s.substring(start, end);
            if(!dict.contains(curr)) continue;
            List<String> suffixes = dfs(s,end);
            for(String suffix : suffixes){
                if(suffix.isEmpty()){
                    res.add(curr);
                }
                else{
                    res.add(curr + " " + suffix);
                }
            }
        }
        return res;
    }
}