class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int pre = 0;
        map.put(0, -1);
        for(int i = 0;i<nums.length;i++){
            pre += nums[i];
            int rem = pre % k;
            if(map.containsKey(rem) && i - map.get(rem) >= 2) return true;
            if(!map.containsKey(rem)) map.put(rem,i);
        }
        return false;
    }
}