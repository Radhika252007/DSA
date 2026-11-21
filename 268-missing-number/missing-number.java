class Solution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int actualSum = (n * (n + 1)/2);
        for(int val : nums){
            sum += val;
        }
        return actualSum - sum;

    }
}