class Solution {
    public int minimumCost(int[] cost) {
        if(cost.length < 3) return Arrays.stream(cost).sum(); 
        Arrays.sort(cost);
        int minCost = 0;
        int i = cost.length - 1;
        int j = cost.length - 2;
        while(i >= 0|| j >=0){
            int a = 0;
            int b = 0;
            if(i >= 0){
            a = cost[i];
            }
            if(j>=0){
            b = cost[j];
            }
            minCost += a + b;
                i-=3;
                j-=3;
            
        }
        return minCost;
    }
}