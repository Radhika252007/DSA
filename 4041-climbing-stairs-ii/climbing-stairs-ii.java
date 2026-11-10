class Solution {
    int[] dp;
    public int climbStairs(int n, int[] costs) {
        dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1;i<=n;i++){
            int cost1 = Integer.MAX_VALUE;
            int cost2 = Integer.MAX_VALUE;
            int cost3 = Integer.MAX_VALUE;
            if(i-1 >= 0){
                cost1 = costs[i-1] + 1 + dp[i-1];
            }
            if(i-2 >= 0){
                cost2 = costs[i-1] + 4 + dp[i-2];
            }
            if(i-3 >= 0){
                cost3 = costs[i-1] + 9 + dp[i-3];
            }
            dp[i] = Math.min(cost1, Math.min(cost2, cost3));
        }
        return dp[n];
        // Arrays.fill(dp,-1);
        // return findAns(n, costs, 0);
    }

    int findAns(int n, int[] costs, int i) {
        if (i == n) return 0;
        if(dp[i] != -1) return dp[i];
        int cost1 = Integer.MAX_VALUE;
        int cost2 = Integer.MAX_VALUE;
        int cost3 = Integer.MAX_VALUE;

        if (i + 1 <= n) {
            cost1 = costs[i] + 1 + findAns(n, costs, i + 1);
        }

        if (i + 2 <= n) {
            cost2 = costs[i + 1] + 4 + findAns(n, costs, i + 2);
        }

        if (i + 3 <= n) {
            cost3 = costs[i + 2] + 9 + findAns(n, costs, i + 3);
        }

        return dp[i] = Math.min(cost1, Math.min(cost2, cost3));
    }
}