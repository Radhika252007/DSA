class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] flags = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(matrix[i][j] == 0){
                    flags[i][j] = true;
                }
            }
        }
        for(int i = 0;i<m;i++){
            for(int j =0;j<n;j++){
                if(flags[i][j]){
                    int r = i;
                    int c = j;
                    while(r >= 0){
                        matrix[r--][j] = 0;
                    }
                    r = i;
                    while(r < m){
                        matrix[r++][j] = 0;
                    }
                    while(c >=0){
                        matrix[i][c--] = 0;
                    }
                    c = j;
                    while(c < n){
                        matrix[i][c++] = 0;
                    }
                }
            }
        }
    }
}