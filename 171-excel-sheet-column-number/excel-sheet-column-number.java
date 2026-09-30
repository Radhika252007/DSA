class Solution {
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for(int i = 0;i<columnTitle.length();i++){
            int c = columnTitle.charAt(i) - 'A';
            ans = ans * 26 + ((c % 26)+1);
        }
        return ans;
    }
}