class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1;i>=0;i--){
            for(int j=i;j<n;j++){
                if(s.charAt(i) == s.charAt(j) && (j - i <=1 ||dp[i+1][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        backtrack(0,s,dp,ans,curr);
        return ans;
    }
    public void backtrack(int start, String s,boolean[][] dp, List<List<String>> ans, List<String> curr){
        if(start == s.length()) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int end = start; end < s.length(); end++){
            if(dp[start][end]){
                curr.add(s.substring(start,end+1));
                backtrack(end+1,s,dp,ans,curr);
                curr.remove(curr.size()-1);
            }
        }

    }
}