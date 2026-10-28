class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder f = new StringBuilder();
        int depth = 0;
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '(') depth++;
            else if(s.charAt(i) == ')'){
                if(depth == 0) continue;
                depth--;
            }
            f.append(s.charAt(i));
        }
        depth = 0;
        StringBuilder ans = new StringBuilder();
        for(int i = f.length()-1;i>=0;i--){
            if(f.charAt(i) == ')') depth++;
            else if(f.charAt(i) == '('){
                if(depth == 0) continue;
                depth--;
            }
            ans.append(f.charAt(i));
        }
        return ans.reverse().toString();
    }
}