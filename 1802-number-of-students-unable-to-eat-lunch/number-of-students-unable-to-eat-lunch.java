class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        for(int val : students){
            q.offer(val);
        }
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0;j<size;j++){
                int curr = q.poll();
                if(curr != sandwiches[i]){
                    q.offer(curr);
                }
                else{
                    i++;
                }
                if(i == sandwiches.length) break;
            }
            if(i == sandwiches.length) break;
            if(q.size() == size) break;
        }
        return q.isEmpty() ? 0 : q.size();
    }
}