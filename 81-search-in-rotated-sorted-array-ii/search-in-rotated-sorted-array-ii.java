class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0, end = nums.length-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(target==nums[mid]){
                return true;
            }
            if(nums[start]==nums[mid]&&nums[end]==nums[mid]){
                start++;
                end--;
            }
            else if(nums[start]<=nums[mid]){
                if(target>=nums[start] && target <nums[mid]){
                    end = mid - 1;
                }
                else{
                    start = mid +1;
                }
            }
            else{
                if(target<=nums[end] && target>nums[mid]){
                    start = mid +1;
                }
                else{
                    end = mid -1;
                }
            }
        }
        return false;
    }
}
