class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        int k = 0;
        for(int val : nums){
            if(val < pivot){
                ans[k++] = val;
            }
        }
        for(int val: nums){
            if(val == pivot){
                ans[k++] = val;
            }
        }
        for(int val: nums){
            if(val > pivot){
                ans[k++] = val;
            }
        }
        return ans;
    }
}