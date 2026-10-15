class Solution {
    public int strStr(String haystack, String needle) {
        int[] lps = lps(needle);
        int i = 0;
        int j = 0;
        while(i < haystack.length() && j < needle.length()){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                if(j == needle.length()) return i - j;
            }
            else{
                if(j == 0){
                    i++;
                }
                else{
                    j = lps[j-1];
                }
            }
        }
        return -1;

    }
    public int[] lps(String s){
        int m = s.length();
        int len = 0;
        int i = 1;
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
        return lps;
    }
}