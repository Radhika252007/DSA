class Solution {
    public boolean checkOnesSegment(String s) {
        boolean flag = false;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '1' && !flag){
                flag = true;
                i++;
                while(i<s.length() && s.charAt(i)=='1'){
                    i++;
                }
            }
            else if(ch=='1' && flag){
                return false;
            }
        }
        return true;
    }
}