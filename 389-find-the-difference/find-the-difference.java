class Solution {
    public char findTheDifference(String s, String t) {
        char[] freq1 = new char[26];
        char[] freq2 = new char[26];
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            freq1[ch - 'a']++;
        }
        for(int j=0;j<t.length();j++){
            char ch = t.charAt(j);
            freq2[ch - 'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]) return (char)(i+'a');
        }
        return 'a';
    }
}