class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->b[1] - a[1]);
        int maxUnits = 0;
        int size = 0;
        for(int  i =0;i<boxTypes.length;i++){
            int s = boxTypes[i][0];
            int u = boxTypes[i][1];
            if(size + s > truckSize){
                maxUnits += (truckSize * u);
                break;
            }
            else{
                maxUnits += (s * u);
                truckSize -= s;
            }
        }
        return maxUnits;

    }
}