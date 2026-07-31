class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for(int i = 0;i<word.length();i++){
            freq[word.charAt(i) - 'a']++;
        }
        Arrays.sort(freq);
        int count = 0;
        int j = 0;
        for(int i =  25;i>=0;i--){
            if(freq[i] == 0) break;
            count += ((j / 8) + 1) * freq[i];
            j++;
        }
        return count;
    }
}