class Solution {
    public int lengthOfLastWord(String s) {
        String stripped = s.strip();
        int count  = 0;
        for(int i = stripped.length()-1;i>=0;i--){
            if(stripped.charAt(i)!=' '){
                count++;
            }
            else if(stripped.charAt(i)==' '){
                return count;
            }
        }
        return count;
    }
}