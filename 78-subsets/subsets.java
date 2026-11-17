class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), ans);
        return ans;
    }
    public void solve(int[] nums, int i, List<Integer> curr, List<List<Integer>> ans){
        if(i == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        solve(nums, i+1, curr, ans);
        curr.add(nums[i]);
        solve(nums, i+1, curr, ans);
        curr.remove(curr.size()-1);
    }
}