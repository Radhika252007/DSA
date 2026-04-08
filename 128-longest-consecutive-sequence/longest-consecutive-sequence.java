class Solution {
    public int longestConsecutive(int[] nums) {
       HashSet<Integer> set = new HashSet<>();
       for(int num: nums){
        set.add(num);
       } 
       int max = 0;
       for(int val : set){
            if(!set.contains(val-1)){
                int lo = val;
                int count = 1;
                while(set.contains(lo+1)){
                count++;
                lo++;
            
            }
            max = Math.max(max,count);
       }
       }
       return max;
    }
}