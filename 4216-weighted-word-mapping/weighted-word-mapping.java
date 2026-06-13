class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder res = new StringBuilder();
        for(String word : words){
            int weight = 0;
            for(int i = 0;i<word.length();i++){
                char ch = word.charAt(i);
                weight += weights[ch - 'a'];
            }
            char c = (char)('z' - (weight % 26));
            res.append(c);
        }
        return res.toString();
    }
}