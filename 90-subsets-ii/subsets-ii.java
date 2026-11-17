class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>();
         Arrays.sort(nums);
         solve(nums, 0, ans, new ArrayList<>());
         return ans;
    }
    public void solve(int[] nums, int i, List<List<Integer>> ans, List<Integer> curr){
        if(i == nums.length){
            if(ans.contains(curr)) return;
            ans.add(new ArrayList<>(curr));
            return;
        }
        solve(nums, i+1, ans, curr);
        curr.add(nums[i]);
        solve(nums, i+1, ans, curr);
        curr.remove(curr.size()-1);
    }
}