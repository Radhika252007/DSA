class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        for(List<String> t : tickets){
            if(!map.containsKey(t.get(0))){
                map.put(t.get(0), new PriorityQueue<>());
            }
            map.get(t.get(0)).offer(t.get(1));
        }
        List<String> ans = new ArrayList<>();
        dfs("JFK", ans, map);
        Collections.reverse(ans);
        return ans;
    }
    public void dfs(String curr, List<String> ans, HashMap<String, PriorityQueue<String>> map){
        PriorityQueue<String> pq = map.get(curr);
        while(pq != null && !pq.isEmpty()){
            String next = pq.poll();
            dfs(next, ans, map);
        }
        ans.add(curr);
    }
}