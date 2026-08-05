class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->a[0] - b[0]);
        int[] curr = intervals[0];
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] > curr[1]){
                list.add(curr);
                curr = intervals[i];
            }
            else{
                curr[0] = Math.min(curr[0], intervals[i][0]);
                curr[1] = Math.max(curr[1], intervals[i][1]);
            }
        }
        list.add(curr);
        return list.toArray(new int[list.size()][]);
    }
}