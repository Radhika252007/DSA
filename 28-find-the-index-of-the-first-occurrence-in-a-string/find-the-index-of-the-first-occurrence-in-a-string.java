class Solution {
    public int strStr(String haystack, String needle) {
       String newString = needle + "$" + haystack;
       int[] z = new int[newString.length()];
       int l = 0;
       int r = 0;
       int n = newString.length();
       for(int i = 0;i<newString.length();i++){
            if(i <= r){
                z[i] = Math.min(r - i + 1, z[i - l]);
            }
            while(i + z[i] < n && newString.charAt(z[i]) == newString.charAt(i + z[i])){
                z[i]++;
            }
            if(i + z[i] - 1 > r){
                l = i;
                r = i + z[i] - 1;
            }
       } 
       for(int i = 0;i<z.length;i++){
        if(z[i] == needle.length()) return i - (needle.length() + 1);
       }
       return -1;
    }
}