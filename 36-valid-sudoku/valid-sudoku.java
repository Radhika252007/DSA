class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]!='.' && !isSafe(board,i,j,Character.getNumericValue(board[i][j]))){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isSafe(char[][] board, int row, int col, int num){
        for(int i=0;i<board.length;i++){
            if(i!=col && Character.getNumericValue(board[row][i])==num){
                return false;
            }
        }
        for(int i=0;i<board.length;i++){
            if(i!=row && Character.getNumericValue(board[i][col])==num){
                return false;
            }
        }
        int sqrt = (int)Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;
        for(int i=rowStart;i<rowStart+sqrt;i++){
            for(int j=colStart;j<colStart+sqrt;j++){
                if((i!=row || j!=col) && Character.getNumericValue(board[i][j])==num){
                    return false;
                }
            }
        }
        return true;
    }
}