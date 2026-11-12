class Solution {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for(int val : nums){
            max = Math.max(max, val);
        }
        int[] points = new int[max + 1];
        for(int val : nums){
            points[val] += val;
        }
        int[] dp = new int[max + 1];
        dp[0] = 0;
        if(max >= 1){
            dp[1] = points[1];
        }
        for(int i = 2;i<=max;i++){
            dp[i] = Math.max(dp[i-1], points[i] + dp[i-2]);
        }
        return dp[max];

    }
}