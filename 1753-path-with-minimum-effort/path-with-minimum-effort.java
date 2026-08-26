class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] directions = {
            {1,0}, {0,1}, {0,-1}, {-1,0}
        };
        int[][] efforts = new int[n][m];
        for(int[] arr : efforts){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        efforts[0][0] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.effort - y.effort);
        pq.offer(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int r = curr.i;
            int c = curr.j;
            int eff = curr.effort;
            if(r == n-1 && c == m-1) return eff;
            for(int i = 0;i<4;i++){
                int adjR = directions[i][0] + r;
                int adjC = directions[i][1] + c;
                if(adjR < n && adjR >=0 && adjC < m && adjC >=0){
                    int currEff = Math.max(eff,Math.abs(heights[adjR][adjC] - heights[r][c]));
                    if(currEff < efforts[adjR][adjC]){
                        efforts[adjR][adjC] = currEff;
                        pq.offer(new Pair(adjR, adjC, currEff));
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
    int effort;
    Pair(int i, int j, int effort){
        this.i = i;
        this.j = j;
        this.effort = effort;
    }
}