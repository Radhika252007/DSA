class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc = 1;
        int dec = 1;
        int maxI = 1;
        int maxD = 1;
        int i = 1;
        while(i < nums.length){
            if(nums[i] > nums[i-1]){
                inc++;
            }
            else{
                inc = 1;
            }
            if(nums[i] < nums[i-1]){
                dec++;
            }
            else{
                dec=1;
            }
            maxI = Math.max(inc, maxI);
            maxD = Math.max(maxD, dec);
            i++;
        }
        return Math.max(maxD, maxI);

    }
}