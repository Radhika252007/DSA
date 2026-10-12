class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        long ans = 0;
        int i = 0;
        while(i < s.length() && s.charAt(i) == ' ')i++;
        if(i < s.length()){
            if(s.charAt(i) == '-'){
                sign = -1;
                i++;
            }
            else if(s.charAt(i) == '+') i++;
        }
        while(i < s.length()){
            if(!Character.isDigit(s.charAt(i))) break;
            else{
                ans = ans * 10 + (s.charAt(i) - '0');
                if(ans * sign <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                if(ans * sign >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
            }
            i++;
        }
        return sign  == -1 ? (int)-ans : (int)ans;
    }
}