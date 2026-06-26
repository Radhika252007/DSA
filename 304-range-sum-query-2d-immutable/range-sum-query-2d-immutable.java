class NumMatrix {
    int[][] matrix;
    int[][] prefix;
    public NumMatrix(int[][] matrix) {
        this.matrix = matrix;
        this.prefix = new int[matrix.length][matrix[0].length];
        calculatePrefix();
    }
    public void calculatePrefix(){
        prefix[0][0] = matrix[0][0];
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(i==0 && j==0) continue;
                int top = 0;
                int left = 0;
                int topLeft = 0;
                if(i-1 >=0) top = prefix[i-1][j];
                if(j-1 >=0) left = prefix[i][j-1];
                if((i-1) >=  0 && (j-1) >=0) topLeft = prefix[i-1][j-1];
                prefix[i][j] = matrix[i][j] + top + left - topLeft;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top = 0;
        int left = 0;
        int topLeft = 0;
        if((row1 - 1) >= 0) top = prefix[row1 - 1][col2];
        if((col1 - 1) >= 0) left = prefix[row2][col1 - 1];
        if((row1  - 1) >= 0 && (col1 - 1) >= 0) topLeft = prefix[row1 - 1][col1 - 1];
        return prefix[row2][col2] - top - left + topLeft;


    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */