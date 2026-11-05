class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int val : nums) total += val;
        if(total % 2 != 0) return false;
        int sum = total / 2;
        boolean[][] dp = new boolean[nums.length][sum+1];
        if(nums[0] <= sum) dp[0][nums[0]] = true;
        for(int i = 1;i<nums.length;i++){
            for(int s = 0;s <=sum;s++){
                boolean notTake = dp[i-1][s];
                boolean take = false;
                if(s - nums[i] >= 0){
                    take = dp[i-1][s - nums[i]];
                }
                dp[i][s] = notTake || take;
            }
        }
        return dp[nums.length-1][sum];
    }
}