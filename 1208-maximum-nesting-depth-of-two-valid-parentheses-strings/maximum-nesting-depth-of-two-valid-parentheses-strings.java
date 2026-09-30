class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int depth = 0;
        int[] res = new int[seq.length()];
        for(int i = 0;i<seq.length();i++){
            char c = seq.charAt(i);
            if(c == '('){
                depth++;
                res[i] = depth%2;
            }
            else if(c == ')'){
                res[i] = depth%2;
                depth--;
            }
        }
        return res;
    }
}