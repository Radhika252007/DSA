class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        getCombinations(res,curr,n,k,1);
        return res;

    }
    public void getCombinations(List<List<Integer>> res, List<Integer> curr, int n , int k,int index){
        if(curr.size()==k){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=index;i<=n;i++){
            if(curr.contains(i)) continue;
            curr.add(i);
            getCombinations(res,curr,n,k,i+1);
            curr.remove(curr.size()-1);
        }

    }
}