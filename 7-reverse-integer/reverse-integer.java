class Solution {
    public int reverse(int x) {
      int ans = 0;
      while(x != 0){
        int digit = x % 10;
        if((ans > 214748364 || (ans == 214748364 && digit >7)) || ((ans < -214748364)|| (ans == -214748364 && digit < -8))) return 0;
        ans = ans * 10 + digit;
        x /= 10;
      }
      return ans;
    }
}