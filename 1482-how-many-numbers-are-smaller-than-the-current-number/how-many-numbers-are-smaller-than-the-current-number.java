class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        
        int max = nums[0];
        for(int num : nums){
            max = Math.max(max,num);
        }
        int[] count = new int[max + 1];
        for(int num : nums){
            count[num]++;
        }
        for(int i = 1;i<count.length;i++){
            count[i] += count[i-1];
        }
        int[] res = new int[nums.length];
        int k = 0;
        for(int i=0;i<nums.length;i++){
           if(nums[i] == 0){
            res[k++] = 0;
           }
           else{
            res[k++] = count[nums[i] - 1];
           }
        }
        return res;
        
        
    }
}