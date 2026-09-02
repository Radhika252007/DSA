class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> list = new HashSet<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            List<Integer> curr = new ArrayList<>();
            curr.add(nums[i]);
            getSub(nums,i+1,list,curr);
        }
        return new ArrayList<>(list);
    }
    public void getSub(int[] nums, int n,Set<List<Integer>> list, List<Integer> curr){
        if(n == nums.length) return;
        if(nums[n] >= curr.get(curr.size()-1)){
            curr.add(nums[n]);
            if(curr.size() >= 2){
            list.add(new ArrayList<>(curr));
            }
            getSub(nums,n+1,list,curr);
            curr.remove(curr.size()-1);
        }
        getSub(nums,n+1,list,curr);

    }
}