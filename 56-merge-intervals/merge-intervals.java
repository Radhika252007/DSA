class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int[] curr = intervals[0];
        for(int i = 1;i<intervals.length;i++){
            if(intervals[i][0] > curr[1]){
                ans.add(curr);
                curr = intervals[i];
            }
            else{
                curr[1] = Math.max(intervals[i][1], curr[1]);
            }
        }
        ans.add(curr);
        int[][] res = new int[ans.size()][2];
        for(int i = 0;i<ans.size();i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}