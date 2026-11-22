class Solution {
    public String simplifyPath(String path) {
        Stack<StringBuilder> st = new Stack<>();
        String ans = "";
        for(int i = 0;i<path.length();i++){
            if(path.charAt(i) == '/') continue;
            StringBuilder temp = new StringBuilder();
            while(i < path.length() && path.charAt(i) != '/'){
                temp.append(path.charAt(i));
                i++;
            }
            if(temp.toString().equals(".")){
                continue;
            }
            else if(temp.toString().equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(temp);
            }
        }
        while(!st.isEmpty()){
            ans = "/" + st.pop() + ans;
        }
        if(ans.isEmpty()) return "/";
        return ans;
    }
}