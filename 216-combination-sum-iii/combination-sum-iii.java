class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1;i<=9;i++){
            if(i > n) continue;
            List<Integer> list = new ArrayList<>();
            list.add(i);
            findCombination(k-1,n,i, list,i, res);
        }
        return res;
    }
    public void findCombination(int k, int n, int start, List<Integer> list, int curr, List<List<Integer>> res ){
        if(k==0) {
            if(curr == n) res.add(new ArrayList<>(list));
            return;
        }
        for(int i = start+1;i<=9;i++){
            if(curr + i <= n){
                list.add(i);
                findCombination(k-1,n,i,list,curr+i, res);
                list.remove(list.size()-1);
            }
        }
    }
}