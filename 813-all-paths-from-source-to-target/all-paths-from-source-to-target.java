class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        curr.add(0);
        dfs(0,graph,curr,list);
        return list;
    }
    public void dfs(int node,int[][] graph, List<Integer> curr, List<List<Integer>> list){
        if(node == graph.length - 1){
            list.add(new ArrayList<>(curr));
            return;
        }
        for(int i : graph[node]){
            curr.add(i);
            dfs(i,graph,curr,list);
            curr.remove(curr.size()-1);
        }
    }
}