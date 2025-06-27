public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int sum  = 0;
        int i = 31;
        while(i>-1){
            sum += (n&1)*(1<<i);
            i--;
            n = n>>1;
        }
        return sum;
    }
}