class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(intervals , (a,b) -> Integer.compare(a[0],b[0]));
        for(int i = 0;i<intervals.length;i++){
            if(list.isEmpty() || list.get(list.size() - 1).get(1) < intervals[i][0]){
                List<Integer> sub = new ArrayList<>();
                sub.add(intervals[i][0]);
                sub.add(intervals[i][1]);
                list.add(sub);
            }
            else{
                int last = list.size() - 1;
                int maxVal = Math.max(list.get(last).get(1) , intervals[i][1]);
                list.get(last).set(1,maxVal);
            }
        }
        int rows = list.size();
int cols = 2;

int[][] matrix = new int[rows][cols];

for (int i = 0; i < rows; i++) {
    for (int j = 0; j < cols; j++) {
        matrix[i][j] = list.get(i).get(j);
    }
}
return matrix;
    }
}