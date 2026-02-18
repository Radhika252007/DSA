class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean flag;
        if((n&1)==1){
            flag = true;
        }
        else{
            flag = false;
        }
        n = n>>1;
        while(n>0){
            if(flag){
                if((n&1)!=0){
                    return false;
                }
                else{
                    flag = false;
                }
            }
            else{
                if((n&1)!=0){
                    flag = true;
                }
                else{
                    return false;
                }
            }
            n = n>>1;
        }
        return true;
    }
}