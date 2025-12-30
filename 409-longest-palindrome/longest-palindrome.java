class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[256];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
        }
        int evenCount = 0;
        int oddCount = 0;
        boolean hasOdd = false;
        for(int i=0;i<256;i++){
            if(freq[i]>0 && freq[i]%2==1){
                oddCount += freq[i]-1;
                hasOdd = true;
            }
            else if(freq[i]>0){
                evenCount += freq[i];
            }
        }
        if(hasOdd){
            oddCount = oddCount + 1;
        }
        return evenCount+oddCount;
    }
}