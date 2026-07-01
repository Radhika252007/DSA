class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        int pre = 0;
        for(int val : nums){
            pre += val;
            ans += map.getOrDefault((pre - goal), 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;
    }
}