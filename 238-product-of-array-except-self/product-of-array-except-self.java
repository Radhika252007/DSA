class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        int[] res = new int[nums.length];
        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for(int i = 1; i < nums.length; i++){
            prefix[i] = nums[i] * prefix[i-1];
        }
        for(int i = nums.length - 2; i >= 0; i--){
            suffix[i] = nums[i] * suffix[i+1];
        }
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0) {
                int pre = 1;
                int suf = 1;
                if(i - 1 >= 0){
                    pre = prefix[i-1];
                }
                if(i+1 < nums.length){
                    suf = suffix[i+1];
                }
                res[i] = pre * suf;
            }
            else{
            res[i] = (prefix[i] / nums[i]) * (suffix[i] / nums[i]);
            }
        }
        return res;
    }
}