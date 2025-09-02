class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] maze = new boolean[n][n];
        List<List<String>> list = new ArrayList<>();
        queens(maze,0,list);
        return list;
    }
    static void queens(boolean[][] maze, int row, List<List<String>> list){
        if(row==maze.length){
            list.add(display(maze));
            return;
        }
        for(int i=0;i<maze.length;i++){
            if(isSafe(maze,row,i)){
                maze[row][i] = true;
                queens(maze,row+1,list);
                maze[row][i] = false;
            }

        }
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
        int maxRight = Math.min(row,maze.length-col-1);
        for(int i= 1;i<=maxRight;i++){
            if(maze[row-i][col+i]){
                return false;
            }
        }
        return true;
    }
    static List<String> display(boolean[][] maze){
        List<String> sol = new ArrayList<>();
        for(int i=0;i<maze.length;i++){
            char[] p = new char[maze.length];
            Arrays.fill(p,'.');
            for(int j=0;j<maze.length;j++){
                if(maze[i][j]){
                    p[j]='Q';
                }
            }
            sol.add(new String(p));
        }
        return sol;
    }
    
    
}