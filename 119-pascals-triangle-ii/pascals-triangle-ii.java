class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long num = 1;
        for(int j=0;j<=rowIndex;j++){
            list.add((int)num);
            num = num*(rowIndex-j)/(j+1);
        }
        return list;
    }
}