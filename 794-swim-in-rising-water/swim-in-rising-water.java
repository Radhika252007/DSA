class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0],0,0});
        int n = grid.length;
        int[][] dist = new int[n][n];
        for(int[] arr : dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        dist[0][0] = grid[0][0];
        int[][] directions = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];
            if(cost > dist[r][c]) continue;
            if(r == n-1 && c == n-1) break;
            for(int i = 0;i<4;i++){
                int adjR = r + directions[i][0];
                int adjC = c + directions[i][1];
                if(adjR >= n || adjR < 0 || adjC < 0 || adjC >= n) continue;
                int newCost = Math.max(cost,grid[adjR][adjC]);
                if(newCost < dist[adjR][adjC]){
                    dist[adjR][adjC] = newCost;
                    pq.offer(new int[]{newCost,adjR, adjC});
                }
            }
        }
        return dist[n-1][n-1];
    }
}