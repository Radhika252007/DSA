class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while(top <= bottom && left <= right){
            int mid1 = top + (bottom - top)/2;
            int midS = matrix[mid1][0];
            int midE = matrix[mid1][matrix[mid1].length - 1];
            if(target >= midS && target <= midE){
                int mid2 = left + (right - left)/2;
                if(matrix[mid1][mid2] == target) return true;
                else if(matrix[mid1][mid2] < target) left = mid2 + 1;
                else right = mid2 - 1;
            }
            else if(target > midE) top = mid1 + 1;
            else bottom = mid1 - 1;
        }
        return false;
    }
}