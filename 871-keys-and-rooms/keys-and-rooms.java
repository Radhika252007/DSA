class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int val : rooms.get(curr)){
                if(!visited[val]){
                    visited[val] = true;
                    q.offer(val);
                }
            }
        }
        for(int i = 0;i<visited.length;i++){
            if(!visited[i]) return false;
        }
        return true;
    }
}