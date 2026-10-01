class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            freq[c - 'a']++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> b.freq - a.freq);
        for(int i = 0;i<26;i++){
            if(freq[i] > 0){
                pq.offer(new Pair((char)(i + 'a'), freq[i]));
            }
        }
        StringBuilder sb = new StringBuilder();
        Pair prev = null;
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            sb.append(curr.c);
            curr.freq = curr.freq-1;
            if(prev != null&& prev.freq > 0){
                pq.offer(prev);
            }
            prev = curr;
        }
        return sb.length() == s.length() ? sb.toString() : "";
    }
}
class Pair{
    char c;
    int freq;
    Pair(char c, int freq){
        this.c = c;
        this.freq = freq;
    }
}