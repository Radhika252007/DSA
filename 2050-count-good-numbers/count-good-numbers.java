class Solution {
    static final long MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        return (int)((pow(5,even) * pow(4,odd)) % MOD);
    }
    public long pow(long b, long e){
        if(e == 0) return 1;
        long half = pow(b,e/2);
        half = (half * half) % MOD;
        if(e % 2 == 1){
            half = (half * b) % MOD;
        }
        return half;
    }
    
}