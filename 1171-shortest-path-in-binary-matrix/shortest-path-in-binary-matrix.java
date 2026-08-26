class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;
        int n = grid.length;
        int[][] directions = {
            {-1,-1}, {-1, 0}, {-1,1},
            {0,-1}, {0,1},
            {1,-1}, {1,0}, {1,1}
        };
        Queue<Pair> q = new LinkedList<>();
        int[][] dist = new int[n][n];
        for(int[] arr : dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dist[0][0] = 1;
        q.offer(new Pair(0,0,1));
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.i;
            int c = curr.j;
            int dis = curr.dist;
            if(r == n-1 && c == n-1) return dis;
            for(int i = 0;i<directions.length;i++){
                int adjR = r + directions[i][0];
                int adjC = c + directions[i][1];
                if(adjR >= 0 && adjR < n && adjC >= 0 && adjC < n && grid[adjR][adjC] != 1){
                    if(dis + 1 < dist[adjR][adjC]){
                        dist[adjR][adjC] = dis + 1;
                        q.offer(new Pair(adjR,adjC,dist[adjR][adjC]));
                    }
                }
            }
        }
        return -1;
    }
}
class Pair{
    int i;
    int j;
    int dist;
    Pair(int i, int j, int dist){
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}