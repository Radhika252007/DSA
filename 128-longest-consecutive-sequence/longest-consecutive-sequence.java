class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int val : nums){
            set.add(val);
        }
        int max = 0;
        for(int val : set){
            if(!set.contains(val - 1)){
                int low = val;
                int c = 0;
                while(set.contains(low)){
                    low++;
                    c++;
                }
                max = Math.max(max, c);
            }
        }
        return max;
    }
}