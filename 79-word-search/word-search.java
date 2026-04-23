class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(checkPath(board,word,seen,i,j,0)) return true;;
            }
        }
        return false;
    }
    public boolean checkPath(char[][] board, String word, boolean[][] seen,int row, int col, int index){
        if(index == word.length()){
            return true;
        }
        if(row<0 || row >= board.length || col <0 || col>=board[0].length || seen[row][col] || board[row][col] != word.charAt(index)){
            return false;
        }
        
        seen[row][col] = true;
        boolean found = checkPath(board,word,seen,row+1,col,index+1) || checkPath(board,word,seen,row,col+1,index+1) || checkPath(board,word,seen,row-1,col,index+1) || checkPath(board,word,seen,row,col-1,index+1);
        seen[row][col] = false;
        return found;
    
    }
}