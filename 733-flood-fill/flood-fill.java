class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[] rows = {-1,1,0,0};
        int[] cols = {0,0,-1,1};
        int n = image.length;
        int m = image[0].length;
        int change = image[sr][sc];
        if (change == color) {
            return image;
        }
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr,sc});
        image[sr][sc] = color;
        visited[sr][sc] = true;
        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            for(int i = 0;i<4;i++){
                int currRow = row + rows[i];
                int currCol = col + cols[i];
                if(currRow < n && currRow >= 0 && currCol < m && currCol >=0 && !visited[currRow][currCol]&&image[currRow][currCol] == change){
                    q.offer(new int[]{currRow,currCol});
                    image[currRow][currCol] = color;
                    visited[currRow][currCol] = true;
                }
            }
        }
        return image;
    }
}