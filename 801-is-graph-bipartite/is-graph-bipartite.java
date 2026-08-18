class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!dfs(graph, colors, i, 0)) {
                    return false;
                }
            }
        }

        return true;
    }
    public boolean dfs(int[][] graph, int[]colors, int node, int col){
        colors[node] = col;
        for(int i = 0;i<graph[node].length;i++){
            int adj = graph[node][i];
            if(colors[adj] == -1){
                if(!dfs(graph,colors,adj,1 - col)) return false;
            }
            else if(colors[adj] == colors[node]) return false;
        }
        return true;
    }
}