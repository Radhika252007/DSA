class Solution {
    public boolean canJump(int[] nums) {
        int maxIdx = 0;
        for(int i = 0;i<nums.length;i++){
            if(i > maxIdx) return false;
            if(i + nums[i] > maxIdx){
                maxIdx = i + nums[i];
            }
        }
        return true;
    }
    
}