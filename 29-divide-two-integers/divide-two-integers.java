class Solution {
    public int divide(int dividend, int divisor) {
        boolean isPos = (dividend < 0 == divisor < 0);
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long  ans = 0;
        while(a >= b){
            int q = 0;
            while(a >= (b<<(q+1))){
                q++;
            }
            ans += (1L << q);
            a -= (b << q);
        }
        if(ans >= (1L << 31) && isPos) return Integer.MAX_VALUE;
        return isPos ? (int)ans : (int)-ans;
    }
}