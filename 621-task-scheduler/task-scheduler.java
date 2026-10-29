class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char task : tasks){
            freq[task - 'A']++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<26;i++){
            if(freq[i] != 0){
                pq.offer(freq[i]);
            }
        }
        Queue<Task> q = new LinkedList<>();
        int timer = 0;
        while(!pq.isEmpty() || !q.isEmpty()){
            timer++;
            if(!pq.isEmpty()){
                int t = pq.poll();
                if(t-1!=0){
                    q.offer(new Task(t-1,timer+n));
                }
            }
            if(!q.isEmpty() && q.peek().timer == timer){
                pq.offer(q.poll().freq);
            }
        }
        return timer;
    }
}
class Task{
    int freq;
    int timer;
    Task(int freq, int timer){
        this.freq = freq;
        this.timer = timer;
    }
}