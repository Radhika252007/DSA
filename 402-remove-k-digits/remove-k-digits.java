class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int rem = 0;
        for(char c : num.toCharArray()){
            while(!st.isEmpty() && st.peek()>c && rem< k){
                st.pop();
                rem++;
            }
            st.push(c);
        }
        while(rem < k){
            st.pop();
            rem++;
        }
        boolean lead = true;
        for(char c : st){
            if(lead && c == '0') continue;
            lead = false;
            sb.append(c);
        }
        if(sb.isEmpty()) return "0";
        return sb.toString();
    }
}