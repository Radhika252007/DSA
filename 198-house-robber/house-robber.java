class Solution {
    int[] memo;
    public int rob(int[] nums) {
        memo = new int[nums.length];
        for(int i = 0 ;i<nums.length;i++){
            memo[i] = -1;
        }
        return getSum(nums,0,0);
    }
    public int getSum(int[] nums, int currSum, int index){
        if(index>=nums.length){
            return 0;
        }
        if(memo[index]!=-1){
            return memo[index];
        }
        int skip = getSum(nums,currSum,index+1);
        int take = nums[index]+getSum(nums,currSum,index+2);
        memo[index] = Math.max(skip,take);
        return memo[index];

    }

}