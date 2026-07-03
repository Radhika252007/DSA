class Solution {
    public void sortColors(int[] nums) {
        int k = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 0){
                nums[i] = nums[k];
                nums[k] = 0;
                k++;
            }
        }
        for(int i = k;i<nums.length;i++){
            if(nums[i] == 1){
                nums[i] = nums[k];
                nums[k] = 1;
                k++;
            }
        }

    }
}