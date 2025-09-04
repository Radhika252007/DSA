class Solution {
    public void solveSudoku(char[][] board) {
        if(sudoku(board)){
            System.out.println(board);
        }

    }
    static boolean sudoku(char[][] board){
        int n = board.length;
        int row = -1;
        int col = -1;
        boolean emptyLeft = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='.'){
                    row = i;
                    col = j;
                    emptyLeft = false;
                    break;
                }
            }
            if(emptyLeft==false){
                break;
            }
        }
        if(emptyLeft){
            return true;
        }
        for(int i=1;i<=9;i++){
            if(isSafe(board, row, col, (char)(i+'0'))){
                board[row][col] = (char)(i+'0');
                if(sudoku(board)){
                    return true;
                }
                board[row][col] = '.';
            }
        }
        return false;
    }
    static boolean isSafe(char[][] board, int row, int col , char num ){
        for(int i=0;i<board.length;i++){
            if(board[row][i] == num){
                return false;
            }
        }
        for(int i=0;i<board.length;i++){
            if(board[i][col]==num){
                return false;
            }
        }
        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for(int r = rowStart; r<rowStart + sqrt;r++){
            for( int c = colStart ; c< colStart+ sqrt;c++){
                if(board[r][c]==num){
                    return false;
                }
            }
        }
        return true;
    }
}