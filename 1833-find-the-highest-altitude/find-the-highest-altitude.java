class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] prefix = new int[n + 1];
        for(int i = 1;i<prefix.length;i++){
            prefix[i] = prefix[i-1] + gain[i-1];
        }
        int max = Integer.MIN_VALUE;
        for(int i : prefix){
            max = Math.max(i,max);
        }
        return max;
    }
}