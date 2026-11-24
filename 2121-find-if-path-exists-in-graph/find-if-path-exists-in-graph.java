class Solution {
    boolean[] visited;
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        visited = new boolean[n];
        return check(adj, source, destination, source);
    }
    public boolean check(List<List<Integer>> adj, int s, int d, int curr){
        if(curr ==  d) return true;
        visited[curr] = true;
        for(int val : adj.get(curr)){
            if(!visited[val]){
                if(check(adj,s,d,val)) return true;
            }
        }
        return false;
    }
}