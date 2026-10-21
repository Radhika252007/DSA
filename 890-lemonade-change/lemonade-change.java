class Solution {
    public boolean lemonadeChange(int[] bills) {
        int change = 0;
        int five = 0;
        int ten = 0;
        for(int bill : bills){
            if(bill == 5){
                five++;
            }
            else if(bill == 10){
                if(five > 0){
                ten++;
                five--;
                }
                else{
                    return false;
                }
            }
            else{
                if(ten >= 1 && five >= 1){
                    ten--;
                    five--;
                }
                else if(five >=3) five-=3;
                else{
                    return false;
                }
            }
        }
        return true;
    }
}