class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int max = 1;
        for(int i = 0;i< trips.length;i++){
            max = Math.max(trips[i][2], max);
        }
        int[] distance = new int[max + 1];
        for(int i =0 ;i< trips.length;i++){
            int from = trips[i][1];
            int to = trips[i][2];
            distance[from] += trips[i][0];
            distance[to] -= trips[i][0];
        }
        int curr = 0;
        for(int i =0;i< distance.length;i++){
            curr += distance[i];
            if(curr > capacity) return false;
        }
        return true;
    }
}