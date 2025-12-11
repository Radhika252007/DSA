class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int remaining = target - nums[i];
            if(map.containsKey(remaining) && map.get(remaining)!=i){
                return new int[]{i,map.get(remaining)};
            }
        }
        return new int[]{-1,-1};
    }
}