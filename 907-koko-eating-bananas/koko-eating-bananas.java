class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for(int val : piles){
            max = Math.max(max, val);
        }
        int start = 1;
        int end = max;
        long ans = max;
        while(start <= end){
            int mid = start + (end - start)/2;
            long v = canFinish(piles, mid);
            if(v <= h){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return (int)ans;
    }
    public long canFinish(int[] arr, int limit){
        long hrsTaken = 0;
        for(int pile : arr){
            hrsTaken += (pile + limit - 1L) / limit;
        }
        return hrsTaken;
    }
}