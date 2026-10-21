class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(g.length == 0 || s.length == 0) return 0;
       Arrays.sort(g);
       Arrays.sort(s);
       int i = 0;
       int j = 0;
       int c = 0;
       while(i < s.length && j < g.length){
        if(g[j] <= s[i]){
            c++;
            i++;
            j++;
        } 
        else{
            i++;
        }
       }
       return c;
    }
}