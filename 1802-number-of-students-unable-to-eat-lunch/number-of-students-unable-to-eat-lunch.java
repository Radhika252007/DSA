class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int square = 0;
        int circle = 0;
        for(int p : students){
            if( p == 0){
                square++;
            }
            else{
                circle++;
            }
        }
        for(int sandwich : sandwiches){
            if(sandwich == 0){
                if(square == 0){
                    return circle;
                }
                square--;
            }
            else{
                if(circle == 0){
                    return square;
                }
                circle--;
            }
        }
        return 0;
    }
}