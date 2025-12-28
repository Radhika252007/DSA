class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k==0) return;
        int[] temp = new int[k];
        int n = nums.length;
        int j = 0;
        for(int i=n-k;i<n;i++){
            temp[j++] = nums[i];
        }
        for(int i=n-k-1;i>=0;i--){
            nums[i+k] = nums[i];
        }
        for(int i=0;i<k;i++){
            nums[i] = temp[i];
        }
    }
}