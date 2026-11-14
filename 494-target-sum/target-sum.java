class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int val : nums) sum += val;
        if(Math.abs(target) > sum) return 0;
        int[][] dp = new int[nums.length][2 * sum + 1];
        int offset = sum;
        if(nums[0] == 0){
            dp[0][offset] = 2;
        }
        else{
            dp[0][offset + nums[0]] = 1;
            dp[0][offset - nums[0]] += 1;
        }
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j< 2*sum+1;j++){
                int plus = 0;
                int minus = 0;
                if(j + nums[i] < 2 * sum + 1){
                    plus = dp[i-1][j + nums[i]];
                }
                if(j - nums[i] >= 0){
                    minus = dp[i-1][j - nums[i]];
                }
                dp[i][j] = plus + minus;
            }
        }
        return dp[nums.length-1][target + offset];
    }
}