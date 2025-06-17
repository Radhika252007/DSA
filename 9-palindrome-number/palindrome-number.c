bool isPalindrome(int x) {
    unsigned int reverse=0;
    int original = x;
    if(x<0){
        return false;
    }
    
    while(x){
        reverse = (reverse*10)+(x%10);
        x = x/10;
    }
    return reverse==original;
}