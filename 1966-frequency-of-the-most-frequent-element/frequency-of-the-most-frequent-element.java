class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        long sum = 0;
        int maxFreq = 1;
        for(int r = 0;r<nums.length;r++){
            sum += nums[r];
            long operations = (long)nums[r] * (r - l + 1) - sum;
            while(operations > k){
                sum -= nums[l];
                l++;
                operations = (long)nums[r] * (r - l + 1) - sum;
            }
            maxFreq = Math.max(maxFreq, r - l + 1);
        }
        return maxFreq;
    }
}