class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0 ;i<expression.length();i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c=='*'){
                List<Integer> s1 = diffWaysToCompute(expression.substring(0,i));
                List<Integer> s2 = diffWaysToCompute(expression.substring(i+1));
                for(int a : s1){
                    for(int b : s2){
                        if(c == '+') res.add(a+b);
                        else if(c == '-') res.add(a-b);
                        else res.add(a * b);
                    }
                }
            }
        }
        if(res.isEmpty()) res.add(Integer.valueOf(expression));
        return res;
    }
}