class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i  =0;i<isConnected.length;i++) adj.add(new ArrayList<>());
        for(int i = 0;i<isConnected.length;i++){
            for(int j =0 ;j<isConnected[0].length;j++){
                if(i == j) continue;
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        int c=  0;
        visited = new boolean[isConnected.length];
        for(int i = 0;i<visited.length;i++){
            if(!visited[i]) {
                c++;
                dfs(adj, i);
            }
        }
        return c;
    }
    public void dfs(List<List<Integer>> adj, int node){
        visited[node] = true;
        for(int val : adj.get(node)){
            if(!visited[val]){
                dfs(adj, val);
            }
        }
    }
}