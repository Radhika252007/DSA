class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1;
        int high = (position[position.length - 1] - position[0])/(m-1);
        int ans = 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(canPlace(position, mid, m)){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
    public boolean canPlace(int[] position, int force, int m){
        int count= 1;
        int last = position[0];
        for(int val: position){
            if(val - last >= force){
                count++;
                last = val;
            }
            if(count >= m) return true;
        }
        return false;
    }
}