class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int sum = 0;
        for(int val : apple){
            sum += val;
        }
        Arrays.sort(capacity);
        int box = 0;
        for(int i = capacity.length-1;i>=0;i--){
            sum = sum - capacity[i];
            box++;
            if(sum <= 0){
                break;
            }
        }
        return box;

    }
}