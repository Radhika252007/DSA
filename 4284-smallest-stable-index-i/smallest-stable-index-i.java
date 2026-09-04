class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int[] max = new int[nums.length];
        max[0] = nums[0];
        int[] min = new int[nums.length];
        min[nums.length-1] = nums[nums.length-1];
        for(int i = 1;i<nums.length;i++){
            max[i] = Math.max(max[i-1],nums[i]);
        }
        for(int i = nums.length-2;i>=0;i--){
            min[i] = Math.min(nums[i], min[i+1]);
        }
        for(int i = 0;i<nums.length;i++){
            if(max[i] - min[i] <= k) return i;
        }
        return -1;
    }
}