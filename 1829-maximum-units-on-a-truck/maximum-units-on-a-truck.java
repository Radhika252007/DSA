class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->Integer.compare(b[1] , a[1]));
        int maxUnits = 0;
        int currBox = 0;
        for(int i = 0;i<boxTypes.length;i++){
            int units = boxTypes[i][0] * boxTypes[i][1];
            if(currBox + boxTypes[i][0] <= truckSize) {
                maxUnits += units;
                currBox += boxTypes[i][0];
            }
            else{
                int canTake = truckSize - currBox;
                maxUnits += canTake * boxTypes[i][1];
                break;
            }
        }
        return maxUnits;
    }
}