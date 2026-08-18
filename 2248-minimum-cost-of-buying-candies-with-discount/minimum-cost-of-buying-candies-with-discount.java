class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int minCost = 0;
        int i = cost.length - 1;
        int skip = 0;
        while(i >= 0){
            if(skip >= 2) {
                skip = 0;
                i--;
                continue;
            }
            minCost += cost[i];
            skip++;   
            i--;         
        }
        return minCost;
    }
}