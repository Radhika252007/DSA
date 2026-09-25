class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for(char c : ransomNote.toCharArray()){
            freq1[c -'a']++;
        }
        for(char c : magazine.toCharArray()){
            freq2[c - 'a']++;
        }
        for(char c : ransomNote.toCharArray()){
            if(freq1[c - 'a']  > freq2[c -'a']) return false;
        }
        return true;
    }
}