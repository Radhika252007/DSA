class Solution {
    public int binaryGap(int n) {
        if((n & (n-1)) == 0) return 0;
        int maxDistance = 0;
        int left = -1;
        int right = 0;
        while(n > 0){
        if((n & 1 )==1){
            if(left!=-1){
                maxDistance = Math.max(maxDistance, right - left);
            }
            left = right;
        }
        n = n >> 1;
        right++;
        
    }
    return maxDistance;
}
}