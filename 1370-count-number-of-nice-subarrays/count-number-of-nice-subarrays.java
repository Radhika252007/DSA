class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        int ans = 0;
        int pre = 0;
        for(int val : nums){
            if(val % 2 == 1){
                pre+=1;
            }
            ans += map.getOrDefault(pre - k, 0);
            map.put(pre, map.getOrDefault(pre, 0) + 1);
        }
        return ans;

    }
}