class Solution {
    public int numberOfSteps(int num) {
        return Steps(num,0);
    }
    static int Steps(int num,int steps){
        if(num==0){
            return steps;
        }
        if(num%2==0){
            return Steps(num/2,steps+1);
        }

            return Steps(num-1,steps+1);

        
    }
}