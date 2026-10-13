class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words){
            map.put(word, map.getOrDefault(word, 0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
            if(a.freq != b.freq) return a.freq - b.freq;
            return b.word.compareTo(a.word);
        });
        for(String word : map.keySet()){
              pq.offer(new Pair(word, map.get(word))); 
              if(pq.size() > k) {
                pq.poll();
              }
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(0,pq.poll().word);
        }
        return ans;

    }
}
class Pair{
    String word;
    int freq;
    Pair(String word, int freq){
        this.word = word;
        this.freq = freq;
    }
}