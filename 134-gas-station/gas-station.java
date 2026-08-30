class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int i = 0;
        int n = gas.length;
        while(i < gas.length){
            int j = 0;
            int tank = 0;
            while(j < gas.length){
                tank += gas[(i + j) % n];
                tank -= cost[(i + j) % n];
                if(tank < 0){
                    i = i + j + 1;
                    tank = 0;
                    break;
                }
                j++;
            }
            if(j == n) return i;
        }
        return -1;
    }
}