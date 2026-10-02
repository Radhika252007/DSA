class Solution {
    public int majorityElement(int[] nums) {
        int freq = 0;
        int ans = 0;
        for(int val : nums){
            if(freq == 0){
                ans = val;
                freq++;
            }
            else if(val == ans){
                freq++;
            }
            else{
                freq--;
            }
        }
        // int c = 0;
        // for(int val : nums){
        //     if(val == ans) c++;
        // }

        // return c > nums.length / 2 ? ans : -1;
        return ans;
    }
}