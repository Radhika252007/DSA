class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '[' || c == '{' || c == '('){
                st.push(c);
            }
            else{
                if(st.isEmpty()){
                    return false;
                }
                else{
                    char el = st.pop();
                    if((c == ')' & el != '(') || (c == '}' & el != '{') || (c == ']' & el != '[')){
                        return false;
                    }
                }

            }
        }
        return st.isEmpty();
    }
}