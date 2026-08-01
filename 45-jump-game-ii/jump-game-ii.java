class Solution {
    public int jump(int[] nums) {
        int start = 0;
        int maxReach = 0;
        int jumps = 0;
        for(int i = 0;i<nums.length-1;i++){
            maxReach = Math.max(maxReach, i + nums[i]);
            if(i == start){
                jumps++;
                start = maxReach;
                if(start >= nums.length - 1) break;
            }
        }
        return jumps;
    }
}