class Solution {
    int[] memo;
    public int climbStairs(int n) {
        memo = new int[n+1];
        Arrays.fill(memo,-1);
        return checkPath(n);
    }
    public int checkPath(int n){
        if(n<=1) return 1;
        if(memo[n]!=-1) return memo[n];
        memo[n] = checkPath(n-1) + checkPath(n-2);
        return memo[n];
    }
}