class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 1;
        for(int val : nums){
            max = Math.max(max, val);
        }
        int start = 1;
        int end = max;
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(checkValid(nums, mid, threshold)){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
    public boolean checkValid(int[] nums, int d, int thres){
        int sum = 0;
        for(int val : nums){
            if(val % d == 0) sum +=(val / d);
            else{
                sum += (val / d + 1);
            }
        }
        if(sum <= thres) return true;
        return false;
    }
}