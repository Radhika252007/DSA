class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i= i;
        this.j = j;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j =0;j<grid[i].length;j++){
                if(grid[i][j] == 2){
                    q.offer(new Pair(i,j));
                }
                else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }
        int n = grid.length;
        int m = grid[0].length;
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};
        int minutes = 0;
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i =0;i<size;i++){
                Pair p = q.poll();
                int r = p.i;
                int c = p.j;
                for(int k=0;k<4;k++){
                    int nr = r + dr[k];
                    int nc = c + dc[k];
                    if(nr < n && nr >=0 && nc < m && nc >=0 && grid[nr][nc]==1){
                        grid[nr][nc] = 2;
                        q.offer(new Pair(nr,nc));
                        fresh--;
                    }
                }
            }
            minutes++;
        }
        if(fresh != 0) return -1;
        return minutes;
    }
}