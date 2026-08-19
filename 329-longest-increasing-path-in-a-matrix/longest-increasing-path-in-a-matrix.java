class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] indegree = new int[m][n];
        int[] rows = {1,-1,0,0};
        int[] cols = {0,0,1,-1};
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                for(int k =0;k<4;k++){
                    int r = i + rows[k];
                    int c = j + cols[k];
                    if(r >= 0 && r < m && c >=0 && c < n && matrix[r][c] < matrix[i][j]){
                        indegree[i][j]++;
                    }

                }
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(indegree[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }
        int maxCount = 0;
        while(!q.isEmpty()){
            maxCount++;
            int size = q.size();
            for(int i = 0;i<size;i++){
                int[] currPos = q.poll();
                int x = currPos[0];
                int y = currPos[1];
                for(int k = 0;k<4;k++){
                    int r = x + rows[k];
                    int c = y + cols[k];
                    if(r >= 0 && r < m && c >=0 && c < n && matrix[r][c] > matrix[x][y]){
                        indegree[r][c]--;
                        if(indegree[r][c] == 0) q.offer(new int[]{r,c});
                    }
                }
            }
        }
        return maxCount;
        
    }
}