class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        Arrays.sort(nums);
        subsets(list,subset,nums,0);
        return list;
    }
    public void subsets(List<List<Integer>> list, List<Integer> subset, int[] nums,int index){
        if(index==nums.length){
            if(list.contains(subset)){
                return;
            }
            list.add(new ArrayList<>(subset));
            return;
        }
        subsets(list,subset,nums,index+1);
         subset.add(nums[index]);
        subsets(list,subset,nums,index+1);
        subset.remove(subset.size()-1);
    }
}