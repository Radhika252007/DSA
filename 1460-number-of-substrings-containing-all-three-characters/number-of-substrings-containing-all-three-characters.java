class Solution {
    public int numberOfSubstrings(String s) {
        int lastA = -1;
        int lastB = -1;
        int lastC = -1;
        int total = 0;
        int min = Integer.MAX_VALUE;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == 'a') lastA = i;
            else if(ch == 'b') lastB = i;
            else lastC = i;
            min = Math.min(lastA, Math.min(lastB, lastC));
            if(lastA != -1 && lastB != -1 && lastC != -1){
                total += (min +1);
            }
        }
        return total;
    }
}