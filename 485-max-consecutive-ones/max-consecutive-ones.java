class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int c = 0;
        int curr = 0;
        for(int val : nums){
            if(val == 1){
                curr++;
                c = Math.max(c,curr);
            }
            else{
                curr = 0;
            }
        }
        return c;
    }
}