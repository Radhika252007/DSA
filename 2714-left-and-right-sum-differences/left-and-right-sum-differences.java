class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = 0;
        for(int i = 1;i<n;i++){
            prefix[i] = prefix[i-1] + nums[i-1];
        }
        int curr = 0;
        for(int i = n-1;i>=0;i--){
            prefix[i] = Math.abs(prefix[i] - curr);
            curr += nums[i];
        }
        return prefix;
        
    }
}