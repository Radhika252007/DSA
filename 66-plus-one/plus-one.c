/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* plusOne(int* digits, int digitsSize, int* returnSize) {
    *returnSize = digitsSize;
        int *result = (int*)malloc(digitsSize*sizeof(int));
    for(int i=digitsSize-1;i>=0;i--){
        if(digits[i]<9){
            digits[i]++;
            for(int j=0;j<=i;j++){
                result[j] = digits[j];
            }
        return result;
        }
        result[i] = 0;
    }
    *returnSize = digitsSize+1;
    int *result2 = (int*)realloc(result,(digitsSize+1)*sizeof(int));
    result2[0] = 1;
    for(int i=1;i<=digitsSize;i++){
        result2[i] = 0;
    }
    return result2;
}