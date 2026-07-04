class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int left = 0;
        int c = 0;
        for(int right = 0;right<nums.length;right++){
           if(nums[right] == 0){
              while(right < nums.length && nums[right] == 0) right++;
              if(right == nums.length) break;
              left = right;
           }
           c = Math.max(c, right - left + 1);
           
        }
        return c;
    }

}