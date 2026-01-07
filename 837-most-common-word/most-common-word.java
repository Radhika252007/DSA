class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase();
        String[] words = paragraph.split("\\s+");
        HashMap<String,Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        for(int i=0;i<banned.length;i++){
            set.add(banned[i]);
        }
        int maxFreq = Integer.MIN_VALUE;
        String res = "";
        for(String word : map.keySet()){
            boolean ban = set.contains(word) ? true : false ;
            
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