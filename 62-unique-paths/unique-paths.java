class Solution {
    int[][] memo;
    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return getPaths(0,0,m,n);
    }
    public int getPaths(int d, int r, int m, int n){
        if(d==m-1 && r==n-1){
            return 1;
        }
        if(d<0 || m<0 || d>=m || r>=n) return 0;
        if(memo[d][r] != -1) return memo[d][r];
        int count = 0;
        count += getPaths(d+1,r,m,n);
        count += getPaths(d,r+1,m,n);
        memo[d][r] = count;
        return count;
    }
}