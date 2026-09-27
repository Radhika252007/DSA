class Solution {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(sb);
                sb = new StringBuilder();
            }
            else if(c == ')'){
                StringBuilder curr = sb;
                sb = st.pop();
                sb.append(curr.reverse());
            }
            else{
                sb.append(c);
            }
        }

        return sb.toString();
    }
}