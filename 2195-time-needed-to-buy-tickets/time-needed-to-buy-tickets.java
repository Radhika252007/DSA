class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int total = 0;
        int curr = tickets[k];
        for(int i = 0;i<tickets.length;i++){
            if(i <= k){
                total += Math.min(tickets[i], curr);
            }
            else{
                total += Math.min(tickets[i], curr - 1);
            }
        }
        return total;
    }
}