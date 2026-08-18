class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i<=nums.length - k;i++){
            Set<Integer> set = new HashSet<>();
            for(int j = i;j<i+k;j++){
                set.add(nums[j]);
            }
            for(int val : set){
                map.put(val, map.getOrDefault(val,0)+1);
            }
        }
        int largest = -1;
        for(int val : map.keySet()){
            if(map.get(val) == 1){
                if(val > largest){
                    largest = val;
                }
            }
        }
        return largest;
    }
}