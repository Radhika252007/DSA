class Solution {
    public int totalFruit(int[] fruits) {
        int f1 = -1;
        int f2 = -1;
        int maxf1 = 0;
        int maxf2 = 0;
        int l =  0;
        int max  = 0;
        for(int r = 0;r < fruits.length;r++){
            if(f1 == -1){
                f1 = fruits[r];
                maxf1 = 1;
            }
            else if(f1!= fruits[r] && f2 == -1){
                f2 = fruits[r];
                maxf2 = 1;
            }
            else if(fruits[r]!=f1 && fruits[r]!=f2){
                while(maxf1 > 0 && maxf2 > 0){
                    if(fruits[l] == f2){
                        maxf2--;
                    }
                    else{
                        maxf1--;
                    }
                    l++;
                }
                if(maxf1 == 0){
                    f1 = f2;
                    f2 = fruits[r];
                    maxf1 = maxf2;
                    maxf2 = 1;
                }
                else{
                    f2 = fruits[r];
                    maxf2 = 1;
                }
            }
            else{
                if(fruits[r] == f1) maxf1++;
                else maxf2++;
            }
            
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}