class Solution {
    public int candy(int[] ratings) {
        int candies = ratings.length;
        int i  = 1;
        while(i < ratings.length){
            while(i < ratings.length && ratings[i] == ratings[i-1]){
                i++;
            }
            int peak = 0;
            while(i < ratings.length && ratings[i] > ratings[i-1]){
                i++;
                peak++;
                candies += peak;
            }
            int valley = 0;
            while( i< ratings.length && ratings[i] < ratings[i-1]){
                i++;
                valley++;
                candies += valley;
            }
            int min = Math.min(valley , peak);
            candies -= min;
        }
        return candies;
    }
}