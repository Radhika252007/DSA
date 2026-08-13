class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            list.get(a).add(b);
        }
        return checkPath(list, numCourses);
    }
        public boolean dfs(ArrayList<ArrayList<Integer>> list , int numCourse, boolean[] visited, boolean[] path, ArrayList<Integer> ans){
            visited[numCourse] = true;
            path[numCourse] = true;
            for(int val : list.get(numCourse)){
                if(!visited[val]){
                    if(!dfs(list,val,visited,path, ans)) return false;
                }
                else if(path[val]){
                    return false;
                }
            }
            path[numCourse] = false;
            ans.add(numCourse);
            return true;
        }
        public int[] checkPath(ArrayList<ArrayList<Integer>> list , int numCourses){
            boolean[] visited = new boolean[numCourses];
            boolean[] path = new boolean[numCourses];
            ArrayList<Integer> ans = new ArrayList<>();
           for(int i = 0; i < numCourses; i++){
    if(!visited[i]){
        if(!dfs(list, i, visited, path, ans))
            return new int[0];
    }
}

    int[] result = new int[numCourses];

    for (int i = 0; i < numCourses; i++) {
        result[i] = ans.get(i);
    }

    return result;
        }
    }
