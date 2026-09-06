class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj.get(a).add(b);
        }
        return checkCycle(numCourses, adj);
    }
    public boolean checkCycle(int numCourses, List<List<Integer>> adj){
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(!visited[i]){
                if(!dfs(i,adj,visited,path)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, List<List<Integer>> adj, boolean[] visited, boolean[] path){
        visited[node] = true;
        path[node] = true;
        for(int val : adj.get(node)){
            if(!visited[val]){
                if(!dfs(val,adj,visited,path)) return false;
            }
            else if(path[val]) return false;
        }
        path[node] = false;
        return true;

    }
}