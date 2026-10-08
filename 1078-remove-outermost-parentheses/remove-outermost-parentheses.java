class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int start = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }
            else{
                st.pop();
                if(st.isEmpty()){
                    start = i+1;
                }
            }
            if(start != i && !st.isEmpty()){
                sb.append(s.charAt(i));
            }

        }
        return sb.toString();
    }
}