class Solution {
    public String addBinary(String a, String b) {
        int x = a.length()-1;
        int y = b.length()-1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();
        while(x >=0 || y>=0 || carry != 0){
            int n = 0;
            int m = 0;
            if(x>=0){
                n = a.charAt(x) - '0';
                x--;
            }
            if(y>=0){
                m = b.charAt(y) - '0';
                y--;
            }
            int sum = n + m + carry;
            carry = sum / 2;
            ans.append("" + (sum % 2));
        }
        return ans.reverse().toString();
    }
}