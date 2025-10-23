class Solution {
    public int minInsertions(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        int res = 0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push('(');
            }
            else{
                if((i+1 )<s.length() && s.charAt(i+1)==')'){
                    i++;
                }
                else{
                    res++;
                }
                if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    res++;
                }
            }
        }
        return res += stack.size()*2;

    }
}