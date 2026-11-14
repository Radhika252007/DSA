class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int val : nums) sum += val;
        if(sum % 2 != 0) return false;
        int total = sum / 2;
        boolean[][] dp = new boolean[nums.length][sum+1];
        if(nums[0] <= sum) dp[0][nums[0]] = true;
        for(int i = 1;i<nums.length;i++){
            for(int t = 0;t <= total;t++){
                boolean notTake = dp[i-1][t];
                boolean take = false;
                if(t - nums[i] >= 0){
                    take = dp[i-1][t - nums[i]];
                }
                dp[i][t] = notTake || take;
            }
        }
        return dp[nums.length-1][total];
    }
}