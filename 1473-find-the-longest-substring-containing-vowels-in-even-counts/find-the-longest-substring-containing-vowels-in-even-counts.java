class Solution {
    public int findTheLongestSubstring(String s) {
        int[] arr = new int[33];
        Arrays.fill(arr,-2);
        arr[0] = -1;
        int mask = 0;
        int maxLen = 0;
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == 'a'){
                mask ^= 1;
            }
            else if(c == 'e'){
                mask ^= 2;
            }
            else if(c == 'i'){
                mask ^= 4;
            }
            else if(c == 'o'){
                mask ^= 8;
            }
            else if(c == 'u'){
                mask ^= 16;
            }
            if(arr[mask] == -2){
                arr[mask] = i;
            }
            else{
                maxLen = Math.max(maxLen, i - arr[mask]);
            }
        }
        return maxLen;
    }
}