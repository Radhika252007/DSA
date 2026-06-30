class Solution {
    public int getLucky(String s, int k) {
        StringBuilder n = new StringBuilder();
        for(char c : s.toCharArray()){
            n.append(c - 'a' + 1);
        }
        String str = n.toString();
        int num = 0;
        for(char c : str.toCharArray()){
            num += (c - '0');
        }
        k--;
        while(k > 0){
            int sum = 0;
            while(num != 0){
                sum += (num % 10);
                num/=10;
            }
            num = sum;
            k--;
        }
        return num;

    }
}