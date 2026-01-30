class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        getSubsets(list,nums,subset,0);
        return list;
    }
    public void getSubsets(List<List<Integer>> list, int[] nums,List<Integer> subset,int index){
        if(index==nums.length){
            list.add(new ArrayList<>(subset));
            return;
        }
        getSubsets(list,nums,subset,index+1);
        subset.add(nums[index]);
        getSubsets(list,nums,subset,index+1);
        subset.remove(subset.size()-1);
    }
}