class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        Sum(candidates,target,0,list,result);
        return list;
    }
    static void Sum(int[] arr, int target, int index, List<List<Integer>> list,List<Integer> result){
        if(target==0){
            list.add(new ArrayList<>(result));
            return;
        }
        if(index==arr.length || target<0){
            return;
        }
        result.add(arr[index]);
        Sum(arr,target-arr[index],index,list,result);
        result.remove(result.size()-1);
        Sum(arr,target,index+1,list,result);
    }
}