class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if( k < 0 || k > n) return -1;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += cardPoints[i];
        }
        if (k == n) {
            return total;
        }
        int maxScore = 0;
        int currScore = 0;
        for(int i = 0;i < k;i++){
            currScore += cardPoints[i];
        }
        maxScore = currScore;
        int r = n - 1;
        for(int i = k -1;i>=0;i--){
            currScore -= cardPoints[i];
            currScore += cardPoints[r];
            r--;
            if(currScore > maxScore) maxScore = currScore;
        }
        return maxScore;

    }
}