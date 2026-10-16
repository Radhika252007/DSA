class Solution {
    public String longestPrefix(String s) {
        if (s.length() <= 1) return "";
        int[] lps = new int[s.length()];
        int i = 1;
        int m = s.length();
        int len = 0;
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
        return s.substring(0,lps[m - 1]);
    }
}