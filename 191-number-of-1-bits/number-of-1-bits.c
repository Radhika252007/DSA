int hammingWeight(int n) {
    int count = 0;
    unsigned int x =1;
    for(int i=0;i<32;i++){
        if(n&(x<<i)){
            count++;
        }
    }
    return count;

}