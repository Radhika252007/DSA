class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] r : prerequisites){
            adj.get(r[0]).add(r[1]);
        }
        return checkCycle(numCourses, adj);
    }
    public boolean checkCycle(int numCourses, List<List<Integer>> adj){
        boolean[] visited = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i = 0;i<numCourses;i++){
            if(!visited[i]){
                if(!dfs(i,visited, path, adj)) return false;
            }
        }
        return true;
    }
    public boolean dfs(int node, boolean[] visited, boolean[] path, List<List<Integer>> adj){
        visited[node] = true;
        path[node] = true;
        for(int a : adj.get(node)){
            if(!visited[a]){
                if(!dfs(a, visited, path, adj)) return false;
            }
            else if(path[a]) return false;
        }
        path[node] = false;
        return true;
    }
}