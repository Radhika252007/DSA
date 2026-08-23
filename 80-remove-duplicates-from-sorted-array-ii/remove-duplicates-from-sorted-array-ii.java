class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int c = 0;
        while(i < nums.length){
            if(i > 0 && nums[i] != nums[i-1]){
                c = 1;
            }
            else{
                c++;
            }
            if(c > 2){
                i++;
            }
            else{
                nums[j] = nums[i];
                i++;
                j++;
            }
        }
        return j;
    }
}