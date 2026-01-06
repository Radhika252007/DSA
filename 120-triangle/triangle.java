class Solution {
    int[][] memory;
    public int minimumTotal(List<List<Integer>> triangle) {
        memory = new int[triangle.size()][triangle.size()];
        for(int i=0;i<triangle.size();i++){
        Arrays.fill(memory[i],Integer.MAX_VALUE);
        }
        return minimum(triangle,0,0);
    }
    public int minimum(List<List<Integer>> triangle, int i, int j){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(memory[i][j]!=Integer.MAX_VALUE){
            return memory[i][j];
        }
        

        int down = minimum(triangle,i+1,j);
        int diag = minimum(triangle,i+1,j+1);
       
        memory[i][j] = triangle.get(i).get(j) + Math.min(down,diag);
        return memory[i][j];
    }
}