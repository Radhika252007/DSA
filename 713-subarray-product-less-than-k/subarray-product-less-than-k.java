class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int n = nums.length;
        int pre = 1;
        int c = 0;
        int left = 0;
        for(int right = 0;right < n;right++){
            pre *= nums[right];
            while(pre >= k){
                pre /= nums[left];
                left++;
            }
            c += (right - left + 1);
        }
        return c;
    }
}