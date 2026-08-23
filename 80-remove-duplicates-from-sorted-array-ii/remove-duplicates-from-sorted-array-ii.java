class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> map = new TreeMap<>();
        for(int val : nums){
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int i = 0;
        for(int val : map.keySet()){
            if(map.get(val) == 1){
                nums[i++] = val;
            }
            else{
                for(int j = 0;j<2;j++){
                    nums[i++] = val;
                }
            }
        }
        return i;

    }
}