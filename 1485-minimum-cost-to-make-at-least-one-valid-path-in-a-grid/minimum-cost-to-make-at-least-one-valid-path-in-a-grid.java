class Solution {
    public int minCost(int[][] grid) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0,0,0});
        int m = grid.length;
        int n = grid[0].length;
        int[][] minCost = new int[m][n];
        for(int[] arr : minCost){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        int[][] directions = {
            {1,0,3}, {0,1,1}, {-1,0,4}, {0,-1,2}
        };
        minCost[0][0] = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int cost = curr[0];
            int r = curr[1];
            int c = curr[2];
            for(int i = 0;i<4;i++){
                int adjR = r + directions[i][0];
                int adjC = c + directions[i][1];
                int dir = directions[i][2];
                if(adjR < m && adjR >=0 && adjC < n && adjC >=0){
                    int newCost = cost + (dir == grid[r][c] ? 0 : 1);
                    if(newCost < minCost[adjR][adjC]){
                        minCost[adjR][adjC] = newCost;
                        pq.offer(new int[]{newCost, adjR, adjC});
                    }
                }
            }
        }
        return minCost[m-1][n-1];

    }
}