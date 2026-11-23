class Solution {
    public int minCost(String colors, int[] neededTime) {
        int sum = 0;
        int p = 0;
        for(int c = 1;c<colors.length();c++){
            if(colors.charAt(c) == colors.charAt(p)){
                if(neededTime[p] > neededTime[c]){
                    sum += neededTime[c];
                }
                else{
                    sum += neededTime[p];
                    p = c;
                }
            }
            else{   
                p = c;
            }
        }
        return sum;
    }
}