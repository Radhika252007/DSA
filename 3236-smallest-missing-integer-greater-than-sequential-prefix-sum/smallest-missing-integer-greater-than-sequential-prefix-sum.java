class Solution {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        int sum = nums[0];
        int minPrefix = Integer.MAX_VALUE;;
        for(int j = 1;j<nums.length;j++){
            if(nums[j] == nums[j-1] + 1){
                sum += nums[j];
            }
            else break;
        }
        while(set.contains(sum)){
            sum++;
        }
        return sum;
    }
}