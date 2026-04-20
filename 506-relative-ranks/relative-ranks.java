class Solution {
    public String[] findRelativeRanks(int[] score) {
       PriorityQueue<Pair> pq = new PriorityQueue<>(
        (a,b) -> a.val - b.val
       );
       for(int i = 0;i<score.length;i++){
        pq.offer(new Pair(i,score[i]));
       }
       String res[] = new String[score.length];
       int k = score.length;
       while(!pq.isEmpty()){
        Pair temp = pq.poll();
        if(k==3){
            res[temp.index] = "Bronze Medal";
        }
        else if(k==2){
            res[temp.index] = "Silver Medal";
        }
        else if(k==1){
            res[temp.index] = "Gold Medal";
        }
        else{
        res[temp.index] = String.valueOf(k);
        }
        k--;
       }

    return res;

    }
}
class Pair{
    int index;
    int val;
    Pair(int index, int val){
        this.index = index;
        this.val = val;
    }
}