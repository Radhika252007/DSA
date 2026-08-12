class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
    adj.add(new ArrayList<>());
}
        for(int i = 0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b =  prerequisites[i][1];
            adj.get(a).add(b);
        }
        return isCycle(adj,numCourses);
    }
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj, int courses){
        boolean[] visited = new boolean[courses];
        boolean[] path = new boolean[courses];
        for(int i = 0;i<courses;i++){
            if(dfs(adj,i, visited, path)) return false;
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int course, boolean[] visited, boolean[] path){
        visited[course] = true;
        path[course] = true;
        for(int val : adj.get(course)){
            if(!visited[val]){
                if(dfs(adj,val,visited, path)) return true;
            }
            else if(path[val]) return true;
        }
        path[course] = false;
        return false;
    }
}