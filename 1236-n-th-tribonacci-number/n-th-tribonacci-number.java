class Solution {
    int[] memo;
    public int tribonacci(int n) {
        memo = new int[n+1];
        return solve(n);
    }
    public int solve(int n){
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        if(memo[n]!=0){
            return memo[n];
        }
        memo[n] = solve(n-1)+solve(n-2)+solve(n-3);
        return memo[n];
    }
}