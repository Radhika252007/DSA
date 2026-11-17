class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        generate(n, ans, "", 0, 0);
        return ans;
    }
    public void generate(int n, List<String> ans, String curr, int open , int close){
        if(curr.length() == 2 * n){
            ans.add(curr);
        }
        if(open < n){
            generate(n, ans, curr + "(", open + 1, close);
        }
        if(close < open){
            generate(n, ans, curr + ")", open, close + 1);
        }
    }
}