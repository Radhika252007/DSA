class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> terminal = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            if(graph[i].length ==0) terminal.add(i);
        }
        boolean[] visited = new boolean[graph.length];
        boolean[] path = new boolean[graph.length];
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<graph.length;i++){
            if(terminal.contains(i)) continue;
                if(dfs(i,graph,visited,path,terminal)){
                    ans.add(i);
                }
            
        }
        ans.addAll(terminal);
        Collections.sort(ans);
        return ans;
    }
    public boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] path, List<Integer> terminal){
        if(terminal.contains(node)) return true;
        vis[node] = true;
        path[node] = true;
        for(int i = 0;i<graph[node].length;i++){
            int adj = graph[node][i];
            if(!vis[adj]){
                if(!dfs(adj,graph,vis,path,terminal)) return false;
            }
            else if(path[adj]) return false;
        }
        path[node] = false;
        return true;
    }
}