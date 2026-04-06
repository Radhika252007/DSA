class Solution {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int count = 0;
        for(int val : set){
            if(val > 0){
                count++;
            }
        }
        return count;
    }
}