class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        int maxCount = 0;
        for(int val : set){
            if(!set.contains(val - 1)){
                int low = val;
                int count = 1;
                while(set.contains(low + 1)){
                    count++;
                    low++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}