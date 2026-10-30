class Solution {
    public String mergeAlternately(String word1, String word2) {
        int i  =0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        while(i < word1.length() || j < word2.length()){
            if(flag){
                if(i < word1.length()){
                    sb.append(word1.charAt(i));
                    i++;
                    if(j < word2.length()){
                    flag = false;
                    }
                }
            }
            else{
                if(j < word2.length()){
                    sb.append(word2.charAt(j));
                    j++;
                    if(i<word1.length()){
                    flag = true;
                    }
                }
            }
        }
        return sb.toString();
    }
}