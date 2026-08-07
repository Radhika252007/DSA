class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] cuts = new int[n+1];
        cuts[n] = -1;
        for(int start = n-1;start>=0;start--){
            int minCuts = Integer.MAX_VALUE;
            for(int end = start;end<n;end++){
                if(isPal(s,start,end)){
                    minCuts = Math.min(1 + cuts[end + 1], minCuts);
                }
            }
            cuts[start] = minCuts;
        }
        return cuts[0];
    }
    
    public boolean isPal(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}