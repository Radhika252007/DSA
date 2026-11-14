class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        for(int i = 0;i<coins.length;i++){
            dp[i][0] = 1;
        }
        for(int a = 0;a<=amount;a++){
            if(a % coins[0] == 0){
                dp[0][a] = 1;
            }
        }
        for(int i = 1;i<coins.length;i++){
            for(int a = 0;a <= amount;a++){
                int notTake = dp[i-1][a];
                int take = 0;
                if(a >= coins[i]){
                    take = dp[i][a - coins[i]];
                }
                dp[i][a] = notTake + take;
            }
        }
        return dp[coins.length-1][amount];
    }
}