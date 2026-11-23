class Solution {
    public int minCost(String colors, int[] neededTime) {
        int sum = 0;
        for(int i = 1;i<colors.length();i++){
            int maxVal = 0;
            while(i < colors.length() && colors.charAt(i) == colors.charAt(i-1)){
                sum += neededTime[i-1];
                maxVal = Math.max(neededTime[i-1], maxVal);
                i++;
            }
            sum += neededTime[i-1];
            maxVal = Math.max(neededTime[i-1], maxVal);
            if(maxVal != 0) sum -= maxVal;
        }
        return sum;

    }
}