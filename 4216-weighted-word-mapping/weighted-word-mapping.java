class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res = "";
        for(String word : words){
            int weight = 0;
            for(int i = 0;i<word.length();i++){
                char ch = word.charAt(i);
                weight += weights[ch - 'a'];
            }
            res += (char)('z' - (weight % 26));
        }
        return res;
    }
}