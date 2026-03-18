class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums,0,nums.length-1,k);
    }
    public int quickSelect(int[] nums, int start, int end, int k){
        if(start > end) return -1;
        int p = partition(nums, start, end);
        if(p == nums.length - k) return nums[p];
        if(p>nums.length - k){
            return quickSelect(nums,start,p-1,k);
        }
        return quickSelect(nums,p+1,end,k);
    }
    public int partition(int[] nums, int start, int end){
        int pivot = nums[end];
        int j = start - 1;
        for(int i=start;i<end;i++){
            if(nums[i]< pivot){
                j++;
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        int temp = nums[j+1];
        nums[j+1] = nums[end];
        nums[end] = temp;
        return j+1;
    }
}