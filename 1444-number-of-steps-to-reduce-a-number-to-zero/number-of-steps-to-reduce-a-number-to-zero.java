class Solution {
    public int numberOfSteps(int num) {
        return Steps(num,0);
    }
    static int Steps(int num,int steps){
        if(num==0){
            return steps;
        }
        if(num%2==0){
            num = num/2;
        }
        else{
            num = num-1;
        }
        steps++;
        return Steps(num,steps++);
    }
}