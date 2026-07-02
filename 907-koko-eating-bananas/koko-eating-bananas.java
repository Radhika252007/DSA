class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = Arrays.stream(piles).max().getAsInt();

        int start = 1;
        int end = maxVal;
        int ans = maxVal;
        while(start <= end){
            int mid = start + (end - start)/2;
            long totalHrs = calculateHrs(piles, mid);
            if(totalHrs <= h){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }
        return ans;
    }
    public long calculateHrs(int[] piles, int speed){
        long totalHrs = 0;
        for(int bananas : piles){
            totalHrs += (bananas + speed - 1L) / speed;
        }
        return totalHrs;
    }
}