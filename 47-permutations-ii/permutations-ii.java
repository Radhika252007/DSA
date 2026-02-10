class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        getPermutations(res,nums,0);
        return res;
    }
    public void getPermutations(List<List<Integer>> res, int[] nums, int idx){
        if(nums.length==idx){
            List<Integer> curr = new ArrayList<>();
            for(int num: nums){
                curr.add(num);
            }
            res.add(curr);
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=idx;i<nums.length;i++){
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            swap(nums,i,idx);
            getPermutations(res,nums,idx+1);
            swap(nums,i,idx);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}