class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] dir = new int[][]{
            {0,1}, {1,0}, {0,-1}, {-1,0}
        };
        int[][] res = new int[rows*cols][2];
        res[0] = new int[]{rStart, cStart};
        int d = 0;
        int steps = 0;
        int i = 1;
        while(i < rows* cols){
            if(d == 0 || d == 2){
                steps++;
            }
            for(int j = 0;j<steps;j++){
                rStart += dir[d][0];
                cStart += dir[d][1];
                if(rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols){
                    res[i++] = new int[]{rStart,cStart};
                }
            }
            d = (d + 1) % 4;
        }
        return res;
    }
}