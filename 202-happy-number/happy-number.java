class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n!=1){
            set.add(n);
            n = findSquare(n);
            if(set.contains(n)){
                return false;
            }
        }
        return true;
    }
    public int findSquare(int n){
        int sum = 0;
        while(n!=0){
            int digit = n%10;
            sum += digit*digit;
            n/=10;
        }
        return sum;
    }
}