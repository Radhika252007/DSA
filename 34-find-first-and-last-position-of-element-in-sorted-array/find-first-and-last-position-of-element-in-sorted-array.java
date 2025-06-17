class Solution {
    public int[] searchRange(int[] nums, int target) {
        int ans1 = Occurence(nums,target,true);
        int ans2 = Occurence(nums,target,false);
        int[] ans = {ans1,ans2};
        
        return ans;
    
    }
    static int Occurence(int[] nums, int target,boolean Occur){
        int start = 0, end = nums.length-1;
        int ans = -1;
    while(start<=end){
        int mid = start + (end-start)/2;
        if(nums[mid]==target){
            ans = mid;
            if(Occur){
            end = mid -1;}
            else{
                start = mid+1;
            }
        }
        else if(target<nums[mid]){
            end = mid-1;
        }
        else{
            start = mid+1;
        }

    }
    return ans;
    }
}