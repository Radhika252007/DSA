class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int i = n-1;
        int j =n-2;
        int sum = 0;
        while(j >= 0 && i>=1){
            sum += Math.min(nums[i],nums[j]);
            j-=2;
            i-=2;
        }
        return sum;
    }
}