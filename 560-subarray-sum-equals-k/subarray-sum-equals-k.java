class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int val = 0;
        int c = 0;
        for(int i = 0;i<nums.length;i++){
            val += nums[i];
            if(map.containsKey(val - k)) c += map.get(val - k);
            map.put(val, map.getOrDefault(val ,0)+1);
        }
        return c;
    }
}