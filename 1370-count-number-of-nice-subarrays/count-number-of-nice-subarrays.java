class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
       return atmost(nums,k) - atmost(nums, k-1);
    }
    public int atmost(int[] nums, int goal){
        int left = 0;
        int pre = 0;
        int ans = 0;
        for(int right = 0;right < nums.length;right++){
            if(nums[right] % 2 == 1) pre += 1;
            while(pre > goal){
                if(nums[left] % 2 == 1) pre -= 1;
                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}