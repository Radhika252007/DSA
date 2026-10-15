class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = 0;
        int i = 1;
        int m = s.length();
        int[] lps = new int[m];
        while(i < m){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len-1];
                }
                else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps[m-1] > 0 && m % (m - len) == 0;
    }
    
}