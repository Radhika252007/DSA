class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] colors = new int[n+1];
        Arrays.fill(colors, -1);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<dislikes.length;i++){
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        boolean[] visited = new boolean[n+1];
        for(int i = 1;i<=n;i++){
            if(!visited[i]){
                if(!dfs(i,adj,colors,visited, 0)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, List<List<Integer>> adj, int[] colors, boolean[] visited, int col){
        visited[node] = true;
        colors[node] = col;
        for(int next : adj.get(node)){
            if(!visited[next]){
                if(!dfs(next,adj,colors,visited,1-col)) return false;
            }
            else if(colors[next] == col) return false;
        }
        return true;
    }
}