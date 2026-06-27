class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0,-1);
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] == 1){
                pre += 1;
            }
            else{
                pre -= 1;
            }
            if(map.containsKey(pre)){
                max = Math.max(i - map.get(pre),max);
            }
            else{
                map.put(pre,i);
            }
        }
        return max;
    }
}