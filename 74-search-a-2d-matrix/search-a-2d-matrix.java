class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = rowBinary(matrix,target);
        if(row==-1){
            return false;
        }
        int start = 0, end = matrix[row].length-1;
        while(start<=end){
            int mid = start + (end - start)/2;
            if(matrix[row][mid]==target){
                return true;
            }
            else if(matrix[row][mid]>target){
                end = mid -1;
            }
            else{
                start = mid +1;
            }
        }
        return false;
    }
    static int rowBinary(int[][] matrix, int target){
        int top=0,bottom=matrix.length-1,mid=0;
        while(top<=bottom){
            mid = top+(bottom-top)/2;
            if(target>=matrix[mid][0] && target<=matrix[mid][matrix[mid].length-1]){
                return mid;
            }
            else if(target>matrix[mid][matrix[mid].length-1]){
                top = mid+1;
            }
            else{
                bottom = mid -1;
            }
        }
        return -1;
    }
}