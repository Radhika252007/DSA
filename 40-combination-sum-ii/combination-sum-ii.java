class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        backtrack(candidates,target,0,list,result);
        return list;
    }
    static void backtrack(int[] arr, int target, int index, List<List<Integer>> list, List<Integer> result){
        if(target==0){
            list.add(new ArrayList<>(result));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(i>index && arr[i]==arr[i-1]) continue;
            result.add(arr[i]);
            backtrack(arr,target-arr[i],i+1,list,result);
            result.remove(result.size()-1);
        }
        
    }
}