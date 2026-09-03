class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> adjs = new ArrayList<>();
        int V = quiet.length;
        for(int i = 0;i < V;i++){
            adjs.add(new ArrayList<>());
        }
        int[] quietness = new int[V];
        for(int i = 0; i < V; i++) {
            quietness[i] = i;
        }
        for(int i = 0;i<richer.length;i++){
            int u = richer[i][1];
            int v = richer[i][0];
            adjs.get(v).add(u);
        }
        int[] indegree = new int[V];
        for(int i = 0; i < V; i++){
            for(int val : adjs.get(i)){
                indegree[val]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<V;i++){
            if(indegree[i] == 0) q.offer(i);
        }
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int it : adjs.get(curr)){
                if(quiet[quietness[curr]] < quiet[quietness[it]]){
                    quietness[it] = quietness[curr];
                }
                indegree[it]--;
                if(indegree[it] == 0) q.offer(it);
            }
        }
        return quietness;
        
    }
}