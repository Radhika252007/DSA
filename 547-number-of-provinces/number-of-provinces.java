class Solution {
    boolean[] visited;
    public int findCircleNum(int[][] isConnected) {
        int c=  0;
        visited = new boolean[isConnected.length];
        for(int i = 0;i<visited.length;i++){
            if(!visited[i]) {
                c++;
                dfs(isConnected, i);
            }
        }
        return c;
    }
    public void dfs(int[][] isConnected, int node){
        visited[node] = true;
        int[] curr = isConnected[node];
        for(int i = 0;i<curr.length;i++){
            if(curr[i] == 1 && !visited[i]){
                dfs(isConnected, i);
            }
        }
    }
}