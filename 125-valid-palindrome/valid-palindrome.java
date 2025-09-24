class Solution {
    public boolean isPalindrome(String s) {
        String lower = s.toLowerCase();
        int i=0,j=s.length()-1;
        while(i<j){
            char left = lower.charAt(i);
            char right = lower.charAt(j);
            if(!((left>='a' && left<='z')|| (left>='0' && left<='9'))){
                i++;
            }
            else if(!((right>='a' && right<='z') || (right>='0' && right<='9'))){
                j--;
            }
            else{ if(left!=right){
                return false;
            }
            i++;
            j--;
            }
        }
        return true;
    }
}