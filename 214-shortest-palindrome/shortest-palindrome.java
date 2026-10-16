class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        String newStr = s + "#" + sb.reverse().toString();
        int[] lps = lps(newStr);
        int matched = lps[newStr.length() - 1];
        String rem = s.substring(matched);
        return new StringBuilder(rem).reverse().toString() + s;
    }
    public int[] lps(String s){
        int m = s.length();
        int i = 1;
        int len = 0;
        int[] lps = new int[s.length()];
        while(i < m){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len - 1];
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