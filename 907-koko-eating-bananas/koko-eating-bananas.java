class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int p : piles){
            max = Math.max(p, max);
        }
        int start = 1;
        int end = max;
        int ans = max;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(check(piles, mid, h)) {
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
    public boolean check(int[] piles, int curr, int limit){
        long hrs = 0;
        for(int p : piles){
            hrs += (p + curr - 1L)/curr;
        }
        return hrs <= limit;
    }

}