class Solution {
    public void nextPermutation(int[] nums) {
        int dip = -1;
        int n = nums.length;
        for(int i = n-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                dip = i;
                break;
            }
        }
        if(dip == -1){
            rev(nums,0,n-1);
            return;
        }
        for(int i = n-1;i>dip;i--){
            if(nums[i] > nums[dip]){
                int temp = nums[i];
                nums[i] = nums[dip];
                nums[dip] = temp;
                break;
            }
        }
        rev(nums,dip+1,n-1);
    }
    public void rev(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}