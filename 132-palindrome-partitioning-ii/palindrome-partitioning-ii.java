class Solution {
    int[] cuts;
    public int minCut(String s) {
        int n = s.length();
        cuts = new int[n];
        Arrays.fill(cuts,-1);
        return minCutHelper(s,0);
    }
    public int minCutHelper(String s, int start){
        if(start == s.length() || isPal(s,start,s.length()-1)){
            return 0;
        }
        if(cuts[start] != -1) return cuts[start];
        int min = Integer.MAX_VALUE;
        for(int end = start;end < s.length();end++){
            if(isPal(s,start,end)){
                int cuts = 1 + minCutHelper(s,end+1);
                min = Math.min(cuts,min);
            }
            
        }
        return cuts[start] = min;
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