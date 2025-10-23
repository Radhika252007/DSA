class Solution {
    public int minAddToMakeValid(String s) {
        if(s.length()==0) return 0;
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if(c==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }
                else{
                    stack.push(c);
                }
            }
            else{
                stack.push(c);
            }
        }
        return stack.size();
    }
}