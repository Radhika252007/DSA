class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        parentheses(n,list,"",0,0);
        return list;
    }
    public void parentheses(int n, List<String> list, String s,int openCount,int closeCount){
        if(s.length()==n*2){
            list.add(s);
            return;
        }
        if(openCount<n){
        parentheses(n,list,s + "(",openCount+1,closeCount);
        }
        if(closeCount<openCount){
        parentheses(n,list,s + ")",openCount,closeCount+1);
        }
    }
}