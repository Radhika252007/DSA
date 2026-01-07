class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase();
        String[] words = paragraph.trim().split("\\s+");
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        int maxFreq = Integer.MIN_VALUE;
        String res = "";
        for(String word : map.keySet()){
            boolean ban = false;
            for(int i=0;i<banned.length;i++){
                if(word.equals(banned[i])){
                    ban = true;
                }
            }
            if(!ban){
                if(map.get(word)>maxFreq){
                    maxFreq = map.get(word);
                    res = word;
                }
            }
        }
        return res;
        
    }
}