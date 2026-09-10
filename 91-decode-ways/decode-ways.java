class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for(int i = 1;i<=s.length();i++){
            if(s.charAt(i-1) != '0'){
                dp[i] += dp[i-1];
            }
            if(i>=2){
                int num = (s.charAt(i-2) - '0') * 10 + (s.charAt(i -1) - '0');
                if(num >= 10 && num <= 26){
                    dp[i] += dp[i-2];
                } 
            }
        }
        return dp[s.length()];

        // return getWays(s,0);
    }
    // public int getWays(String s, int i){
    //     if(i >= s.length()) return 1;
    //     if(s.charAt(i) == '0') return 0;
    //     int count = 0;
    //     count += getWays(s,i+1);
    //     if(i+1 < s.length()){
    //         int num = (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0');
    //         if(num >= 10 && num <= 26){
    //             count += getWays(s,i+2);
    //         }
    //     }
    //     return count;
        
    // }
}