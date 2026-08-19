class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastoccur = new int[26];
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            lastoccur[c - 'a'] = i;
        }
        boolean[] visited = new boolean[26];
        Stack<Character> st = new Stack<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(!visited[c - 'a']){
                while(!st.isEmpty() && c < st.peek() && i < lastoccur[st.peek() - 'a']){
                    char c2 = st.pop();
                    visited[c2 -'a'] = false;
                }
                visited[c - 'a'] = true;
                st.push(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : st){
            sb.append(c);
        }
        return sb.toString();
    }
}