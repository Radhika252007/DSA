class Solution {
    public int rob(int[] nums) {
       if(nums.length == 0) return 0;
       if(nums.length == 1) return nums[0];
       return Math.max(solve(nums, 0, nums.length-2), solve(nums, 1, nums.length-1));
    }
    public int solve(int[] nums, int start, int end){
       int[][] dp = new int[end - start + 1][2];
       int n = end - start + 1;
       dp[0][0] = 0;
       dp[0][1] = nums[start];
       for(int i = 1;i<n;i++){
          int notTake = Math.max(dp[i-1][1], dp[i-1][0]);
          int take = nums[start + i] + dp[i-1][0];
          dp[i][0] = notTake;
          dp[i][1] = take;
       } 
       return Math.max(dp[n-1][0], dp[n-1][1]);
    }
}