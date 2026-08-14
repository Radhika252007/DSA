class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] row = {1,-1,0,0};
        int[] col = {0,0,1,-1};
        Queue<Pair> q = new LinkedList<>();
        int[][] res = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0){
                    q.offer(new Pair(i,j,0));
                    visited[i][j] = true;
                }
            }
        }
        while(!q.isEmpty()){
            Pair curr = q.poll();
            int r = curr.i;
            int c = curr.j;
            for(int i = 0;i<4;i++){
                int currRow = r - row[i];
                int currCol = c - col[i];
                if(currRow >=0 && currCol >=0 && currRow < m && currCol < n){
                    if(!visited[currRow][currCol]){
                        q.offer(new Pair(currRow, currCol, curr.d+1));
                        visited[currRow][currCol] = true;
                    }
                }
            }
            res[r][c] = curr.d;
        }
        return res;
    }
}
class Pair{
    int i;
    int j;
    int d;
    Pair(int i, int j, int d){
        this.i = i;
        this.j = j;
        this.d = d;
    }
}