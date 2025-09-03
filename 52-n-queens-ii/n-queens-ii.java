class Solution {
    public int totalNQueens(int n) {
        boolean[][] maze = new boolean[n][n];
        return queens(maze,0);
    }
    static int queens(boolean[][] maze, int row){
        if(row==maze.length){
            return 1;
        }
        int count = 0;
        for(int i=0;i<maze.length;i++){
            if(isSafe(maze,row,i)){
                maze[row][i] = true;
                count+= queens(maze,row+1);
                maze[row][i] = false;
            }
        }
        return count;
    }
    static boolean isSafe(boolean[][] maze, int row, int col){
        for(int i=1;i<=row;i++){
            if(maze[row-i][col]){
                return false;
            }
        }
        int maxLeft = Math.min(row,col);
        for(int i=1;i<=maxLeft;i++){
            if(maze[row-i][col-i]){
                return false;
            }
        }
        int maxRight = Math.min(row, maze.length-col-1);
        for(int i=1;i<=maxRight;i++){
            if(maze[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
}