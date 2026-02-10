class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        getPermutations(list,nums,0);
        return list;

    }
    public void getPermutations(List<List<Integer>> list, int[]nums,int index){
        if(index == nums.length){
            List<Integer> curr = new ArrayList<>();
            for( int num : nums){
                curr.add(num);
            }
            list.add(curr);
            return;
        }
        
        for(int i=index;i<nums.length;i++){
           swap(nums,i,index);
           getPermutations(list,nums,index+1);
           swap(nums,i,index);
        }
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}