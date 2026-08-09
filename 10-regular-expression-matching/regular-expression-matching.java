class Solution {
    public boolean isMatch(String s, String p) {
        return checkMatch(s,p,s.length()-1, p.length()-1);
    }
    public boolean checkMatch(String s, String p, int idx1, int idx2){
        if(idx1 < 0 && idx2 < 0) return true;
        if(idx2 < 0) return false;
        if(idx1 < 0){
            while(idx2 >= 0){
                if(p.charAt(idx2) != '*') return false;
                idx2 -= 2;
            }
            return true;
        }
        if(p.charAt(idx2) == '*'){
            boolean zero = checkMatch(s,p,idx1,idx2-2);
            char prev = p.charAt(idx2-1);
            boolean oneOrMore = ((prev == '.' || s.charAt(idx1) == prev) && checkMatch(s,p,idx1 - 1, idx2));
            return zero || oneOrMore;
        }
        if(p.charAt(idx2) == s.charAt(idx1) || p.charAt(idx2) == '.'){
            return checkMatch(s,p,idx1-1,idx2-1);
        }
        return false;
    }
}