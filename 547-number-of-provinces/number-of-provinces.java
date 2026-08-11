class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int provinces = 0;
        for(int i = 0;i<n;i++){
            if(visited[i]) continue;
            provinces++;
            q.offer(i);
            visited[i] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for (int j = 0; j < n; j++) {
                    if (isConnected[curr][j] == 1 && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
        }
        }
        return provinces;
    }
}