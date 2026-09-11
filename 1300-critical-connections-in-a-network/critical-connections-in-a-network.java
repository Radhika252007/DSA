class Solution {
    int timer;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        timer = 1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<connections.size();i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        int[] tin = new int[n];
        int[] low = new int[n];
        dfs(0,-1,adj,tin,low,vis,bridges);
        return bridges;
    }
    public void dfs(int node,int parent, List<List<Integer>> adj, int[] tin, int[] low, boolean[] vis, List<List<Integer>> bridges){
        vis[node] = true;
        tin[node] = low[node] = timer;
        timer++;
        for(int val : adj.get(node)){
            if(val == parent) continue;
            if(!vis[val]){
                dfs(val,node,adj,tin,low,vis, bridges);
                low[node] = Math.min(low[node], low[val]);
                if(low[val] > tin[node]){
                    bridges.add(new ArrayList<>(List.of(node, val)));
                }
            }
            else{
                low[node] = Math.min(low[node], low[val]);
            }
        }
    }
}