class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       return atmost(nums,goal) - atmost(nums, goal -1);
    }
    public int atmost(int[] nums, int goal){
        if(goal < 0) return 0;
        int left = 0;
        int pre = 0;
        int c = 0;
        for(int right = 0;right < nums.length;right++){
            pre += nums[right];
            while(pre > goal){
                pre -= nums[left];
                left++;
            }
            c += right - left + 1;
        }
        return c;
    }
}